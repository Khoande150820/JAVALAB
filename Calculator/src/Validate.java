
import java.util.Scanner;


public class Validate {
    static int getInteger(){
        while(true){
            try {
                Scanner sc = new Scanner(System.in);
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a valid integer!");
                System.err.print("Enter again: ");
            }
            
        }
    }
}
