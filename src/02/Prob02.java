import java.util.Scanner;

public class Prob02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int t = Integer.parseInt(in.nextLine()); t > 0; t--) {
            // Each test case
            int currentCase = in.nextLine().substring(0,2);
            if  (currentCase <= 60){
                System.out.println("no ticket");
            }else if(currentCase >= 61 && currentCase <= 80){
                System.out.println("small ticket");
            }else{
                System.out.println("big ticket");
            }
        }

        in.close();
    }
}
