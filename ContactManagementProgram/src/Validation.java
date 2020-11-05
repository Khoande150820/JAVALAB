
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eldee
 */
public class Validation {

    static int getIntInRange(int min, int max) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int result = Integer.parseInt(sc.nextLine().trim());
            if (result < min || result > max) {
                System.out.println("Please enter number between " + min + " and " + max);
            } else {
                return result;
            }
        }
    }

    static String getInputString() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Cannot enter empty input!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    static String getInputPhone() {
        String pattern1 = "[0-9]{9}";
        String pattern2 = "[0-9]{3}[-][0-9]{3}[-][0-9]{4}";
        String pattern3 = "[0-9]{3}[-][0-9]{3}(x)[0-9]{4}";
        String pattern4 = "[0-9]{3}[-][0-9]{3}(ext)[0-9]{4}";
        String pattern5 = "[(][0-9]{3}[-][0-9]{3}[-][0-9]{4}";
        String pattern6 = "[0-9]{3}[.][0-9]{3}[0-9]{4}";
        String pattern7 = "[0-9]{3}[\\s][0-9]{3}[\\s][0-9]{4}";

        while (true) {
            String result = getInputString();
            if (result.matches(pattern1)
                    || result.matches(pattern2)
                    || result.matches(pattern3)
                    || result.matches(pattern4)
                    || result.matches(pattern5)
                    || result.matches(pattern6)
                    || result.matches(pattern7)) {
                return result;
            } else {
                System.out.println("Please enter following format");
                System.out.println("1234567890");
                System.out.println("123-456-7890");
                System.out.println("123-456-7890x1234");
                System.out.println("123-456-7890ext1234");
                System.out.println("(123)-456-7890");
                System.out.println("123.456.7890");
                System.out.println("123 456 7890");
            }
        }
    }

    static int getNextId(ArrayList<Contact> contactList) {
        int i = 1;
        for (Contact c : contactList) {
            if (c.getId() == i) {
                i++;
            } else {
                return i;
            }
        }
        return 1;
    }
}
