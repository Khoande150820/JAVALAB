
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        
        // Step 1: Reead string
        String input = "144sdhkjDFGH!@#$%^22fdsf3";
        int [] number = Analyze.getNumber(input);
        System.out.println(Arrays.toString(number));
        Analyze.getOddNumber(number);
        Analyze.getEvenNumber(number);
        Analyze.getPerfectSquare(number);
        Analyze.getUpperCase(input);
        Analyze.getLowerCase(input);
        Analyze.getSpecialChar(input);
    }
    
}
