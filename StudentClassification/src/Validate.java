
import java.util.Scanner;

public class Validate {

    static double getMark(String subject) {
        while (true) {
            try {
                System.out.print(subject + ": ");
                Scanner sc = new Scanner(System.in);
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < 0) {
                    System.out.println(subject + " is greater or equal zero");
                } else if (result > 10) {
                    System.out.println(subject + " is less than equal ten");
                } else {
                    return result;
                }
            } catch (Exception e) {
                System.out.println(subject + " is digit");
            }
        }
    }

    static String getInputString() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String result = sc.nextLine();
                if (result.isEmpty()) {
                    System.out.println("Cannot enter empty value!");
                    System.out.print("Try again: ");
                } else {
                    return result;
                }
            } catch (Exception e) {
            }
        }
    }

    static boolean getYNinput() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String result = sc.nextLine().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.print("Pleae enter Y/y or N/n: ");
            }

        }
    }
}
