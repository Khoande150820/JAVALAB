
import java.util.Scanner;

/**
 *
 * @author eldee
 */
public class Main {

    static String getInput() {
        System.out.println("Enter your content: ");
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);

                String result = sc.nextLine();
                if (result.isEmpty()) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please enter a string");
                System.err.println("Enter your content:");
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        String input = getInput();
        WordCount.wordCount(input);
        WordCount.letterCount(input);

    }

}
