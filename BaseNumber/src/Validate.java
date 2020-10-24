
import java.util.Scanner;

public class Validate {

    static int validateInteger(int min, int max) {
        // loop until user input integer in rage min - max
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter number in range [" + min + ", " + max + "]");
                System.err.println("Please try again");
            }
        }
    }

    static long getDecimal() {
        System.out.print("Enter decimal number: ");
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                long result = Long.parseLong(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a valid decimal number!");
                System.out.print("Enter again: ");
            }
        }
    }

    static String getBinary() {
        final String BinaryPattern = "[0-1]*";
        System.out.print("Enter binary number: ");
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String output = sc.nextLine();
                if (output.matches(BinaryPattern) && !output.isEmpty()) {
                    return output;
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.err.println("Please enter a valid binary!");
                System.out.print("Enter again: ");
            }

        }
    }

    static String getHex() {
        final String HexPattern = "[0-9A-F]*";
        System.out.print("Enter hexadecimal number: ");
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String output = sc.nextLine();
                if (output.matches(HexPattern) && !output.isEmpty()) {
                    return output;
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                System.err.println("Please enter a valid hexadecimal number!");
                System.out.print("Enter again: ");
            }
        }
    }
}
