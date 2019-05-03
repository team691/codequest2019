import java.util.Scanner;

public class Prob04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int t = Integer.parseInt(in.nextLine()); t > 0; t--) {
            // Each test case
            String entering = in.nextLine();
            int locOfBool =0;//location of boolean
            for(int x=0;x<entering.length();x++){
                if(entering.substring(x,x+1).equals("t") || entering.substring(x,x+1).equals("f")){
                    locOfBool = x;
                }
            }
            int currentCase = Integer.parseInt(entering.substring(0,locOfBool-1));
            if(entering.substring(locOfBool).equals("true")){
                if  (currentCase <= 65){
                    System.out.println("no ticket");
                }else if(currentCase >= 66 && currentCase <= 85){
                    System.out.println("small ticket");
                }else if (currentCase >= 86){
                    System.out.println("big ticket");
                }
            }else{
            
            if  (currentCase <= 60){
                System.out.println("no ticket");
            }else if(currentCase >= 61 && currentCase <= 80){
                System.out.println("small ticket");
            }else{
                System.out.println("big ticket");
            }
        }
        }

        in.close();
    }
}
