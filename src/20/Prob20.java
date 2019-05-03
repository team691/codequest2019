import java.util.Scanner;
import java.util.Arrays;

public class Prob20 {
    static final String[] BIRD_NAMES = new String[] {
        "Accipitridae", "Cathartidae", "Passeridae"
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int t = Integer.parseInt(in.nextLine()); t > 0; t--) {
            Bird[] known = new Bird[in.nextInt()];
            Bird[] unknown = new Bird[in.nextInt()];
            in.nextLine();
            for (int i = 0; i < known.length; i++) {
                known[i] = new Bird(in.nextLine());
            }
            for (int i = 0; i < unknown.length; i++) {
                Bird u = new Bird(in.nextLine());
                int[] votes = new int[3];
                boolean won = false;
                int maxVotePos = 0;
                for (int j = 0; j < known.length; j++) {
                    known[j].calcDist(u);
                    //System.err.println(known[j].dist);
                }
                Arrays.sort(known);
                for (Bird b : known) System.err.println(b);
                for (int k = 0; k < 5 || !won; k++) {
                    votes[known[k].name]++;
                    System.err.println(Arrays.toString(votes));
                    if (k >= 4) {
                        boolean tie = false;
                        for (int w = 1; w < 3; w++) {
                            if (votes[w] > votes[maxVotePos]) {
                                maxVotePos = w;
                                tie = false;
                            } else if (votes[w] == votes[maxVotePos]) {
                                tie = true;
                            }
                        }
                        won = !tie;
                    }
                }
                System.out.println(BIRD_NAMES[maxVotePos]);
            }
        }
        in.close();
    }

    static class Bird implements Comparable<Bird> {
        double[] v = new double[4];
        int name = -1;
        double dist = Double.MAX_VALUE;

        public Bird(String line) {
            String[] tok = line.split(" ");
            if (tok.length == 5) {
                switch (tok[0].charAt(0)) {
                    case 'A':
                        name = 0;
                        break;
                    case 'C':
                        name = 1;
                        break;
                    case 'P':
                        name = 2;
                        break;
                }
            }
            for (int i = 0; i < 4; i++) {
                v[i] = Double.parseDouble(tok[i + (tok.length == 5 ? 1 : 0)]);
            }
        }

        public int compareTo(Bird b) {
            return (int) (dist - b.dist);
        }

        public void calcDist(Bird b) {
            double sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += Math.pow(v[i] - b.v[i], 2);
            }
            dist = Math.sqrt(sum);
        }

        public String toString() {
            return String.format("%s %d %f", Arrays.toString(v), name, dist);
        }
    }
}
