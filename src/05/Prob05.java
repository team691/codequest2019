import java.util.Scanner;

public class Prob05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int t = Integer.parseInt(in.nextLine()); t > 0; t--) {
            int small = in.nextInt();
            int large = in.nextInt();
            int length = in.nextInt();
            int left = length - 5 * Math.min(large, length / 5);
            System.out.println(small >= left);
        }

        in.close();
    }
}
