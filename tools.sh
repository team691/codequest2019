#!/bin/bash
function algo-write-test {
    if [ ! $1 ]; then
        echo Specify name of test!
        return 1
    fi
    if [ ! -d tests/ ]; then mkdir tests/; fi
    touch tests/$1.{in,out}
    if [ ! $ALGO_NO_VIM ]; then
        vim tests/$1.in
        vim tests/$1.out
    fi
    echo "Wrote test '$1'"
}

function algo-run-test {
    local prog=`ls *.java | head -n 1`
    if [ $ALGO_COMPILE ]; then
        javac $prog
        if [ $? != 0 ]; then return; fi
    fi
    prog=$(ls *.class | grep -v '\$' | head -n 1)
    prog=${prog%.class}
    local rtests=`ls tests/*.in`
    if [ $1 ]; then rtests=tests/$1.in; fi
    local tmp_out="tests/tmp.out"
    local t
    for t in $rtests; do
        t=${t%.in}
        echo "Test '${t#tests/}':"
        java $prog < $t.in > $tmp_out
        if diff --strip-trailing-cr $t.out $tmp_out &> /dev/null; then
            rm -f $t.pout
            echo "[32mPASSED[00m"
        else
            cp $tmp_out $t.pout
            echo "[31mFAILED![00m (Program out in $t.pout)"
            diff $t.out $t.pout
        fi
        echo "======================================================="
    done
}

# codequest2019
ALGO_NO_VIM=true
ALGO_COMPILE=true
