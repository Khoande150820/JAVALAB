
import java.util.Scanner;

public class Validate {

    static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.out.println("Please enter integer between " + min + " and " + max);
                    System.out.print("Enter again: ");
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number!");
//                System.out.print("Enter again: ");
            }
        }
    }
    
    static int getPositiveInt(){
           while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 1) {
                    System.out.println("Please enter a positive integer");
                    System.out.print("Enter again: ");
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number!");
                System.out.print("Enter again: ");
            }
        }
    }
    
    static int getNumber(){
                   while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number!");
                System.out.print("Enter again: ");
            }
        }
    }
}
