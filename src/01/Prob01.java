import java.util.Scanner;

public class Prob01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int t = Integer.parseInt(in.nextLine()); t > 0; t--) {
            // Each test case
            System.out.println(in.nextLine().toLowerCase());
        }

        in.close();
    }
}
