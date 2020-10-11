
import java.util.Scanner;

/**
 *
 * @author eldee
 */
public class Main {

    static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String result = sc.nextLine();
        return result;
    }

    public static void main(String[] args) {
        // TODO code application logic here

        String input = getInput();
        WordCount.wordCount(input);
        WordCount.letterCount(input);

    }

}
