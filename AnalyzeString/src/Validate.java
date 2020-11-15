
import java.util.*;

public class Validate {

    public static String validateString() {
        // loop until user enter non empty string
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String result = sc.nextLine();
                if (result.isEmpty()) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.out.println("Input is empty!");
                System.err.println("Enter again: ");
            }
        }
    }

    static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    static boolean isPerfectSquare(int number){
        return (int)Math.sqrt(number) * (int)Math.sqrt(number) == number;
    }
}
