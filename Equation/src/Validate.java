
import java.util.Scanner;

public class Validate {

    static float getCoef(String coef) {
        while (true) {
            try {
                System.out.print("Enter " + coef +": ");
                Scanner sc = new Scanner(System.in);
                float result = Float.parseFloat(sc.nextLine().trim());
                return result;
            } catch (Exception e) {
                System.err.println("Please input number");
            }
        }
    }

    static int getInputByLimit(int min, int max) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int output = Integer.parseInt(sc.nextLine().trim());
                if (output < min || output > max) {
                    System.out.println("Please enter a number between" + min + " and " + max);
                    System.out.print("Enter again: ");
                    continue;
                } else {
                    return output;
                }
            } catch (Exception e) {
                System.err.println("Please enter a number!");
                System.out.print("Enter again: ");
            }
        }
    }

    static boolean isEven(double a) {
        return a % 2 == 0;
    }

    static boolean isPerfectSquare(float number) {
        return (int) Math.sqrt(number) * (int) Math.sqrt(number) == number;
    }
}
