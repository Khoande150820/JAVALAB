package util;

import java.util.Scanner;

public class Validate {

    private final static Scanner sc = new Scanner(System.in);
    // Check user Integer input limit
    static int validateIntLimit(int min, int max) {
        // loop until user input integer in rage min - max
        while (true) {
            try {
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
    
    
}
