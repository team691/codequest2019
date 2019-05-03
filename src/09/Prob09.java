import java.util.Scanner;

public class Prob09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int t = Integer.parseInt(in.nextLine()); t > 0; t--) {
            int seconds = 0;
            int minutes = 0;
            int hours = 0;
            String h;
            String m;
            String s;
            String word = in.nextLine();
             
            for (int i = 0; i < word.length(); i++) {
                if (word.substring(i, i + 1).equals("s")) {
                    if (word.length() == 2) {
                        seconds = Integer.valueOf(word.substring(i - 1, i));
                    } else if (word.length() == 3) {
                        seconds = Integer.valueOf(word.substring(i - 2, i));
                    } else {
                        if (word.indexOf("s") < word.indexOf(",")) {
                            seconds = Integer.valueOf(word.substring(0, word.indexOf("s")));
                        } else {
                            seconds = Integer.valueOf(word.substring(word.indexOf(",") + 1, word.indexOf("s")));
                        }
                    }

                } else if (word.substring(i, i + 1).equals("m")) {
                    if (word.length() == 2) {
                        minutes = Integer.valueOf(word.substring(i - 1, i));
                    } else if (word.length() == 3) {
                        minutes = Integer.valueOf(word.substring(i - 2, i));
                    } else {
                        if (word.indexOf("m") < word.indexOf(",")) {
                            minutes = Integer.valueOf(word.substring(0, word.indexOf("m")));
                        } else {
                            minutes = Integer.valueOf(word.substring(word.indexOf(",") + 1, word.indexOf("m")));
                        }
                    }

                } else if (word.substring(i, i + 1).equals("h")) {
                    if (word.length() == 2) {
                        hours = Integer.valueOf(word.substring(i - 1, i));
                    } else if (word.length() == 3) {
                        hours = Integer.valueOf(word.substring(i - 2, i));
                    } else {
                        if (word.indexOf("h") < word.indexOf(",")) {
                            hours = Integer.valueOf(word.substring(0, word.indexOf("h")));
                        } else {
                            hours = Integer.valueOf(word.substring(word.indexOf(",") + 1, word.indexOf("h")));
                        }
                    }
                }
                } 
            
                h = "" + hours;
                m = "" + minutes;
                s = "" + seconds; 
                if (hours < 10) {
                    h = "0" + hours;
                }
                if (minutes < 10) {
                    m = "0" + minutes;
                }
                if (seconds < 10) {
                    s = "0" + seconds; 
                }
            System.out.println(h+":"+m+":"+s);    
            
            
        }

        in.close();
    }
}
