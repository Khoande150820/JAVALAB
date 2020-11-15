
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        // Step 1: create variable to store output
        HashMap<String, ArrayList<Integer>> AnalyzedNumber = new HashMap<>();
        HashMap<String, String> AnalyzedString =  new HashMap<>();
        
        // Step 2: Get input
        System.out.print("Input String: ");
        String input = Validate.validateString();
        
        // Step 3: Analyzed input and add result to hashmap
        Analyze.getAllNumber(input, AnalyzedNumber);
        Analyze.getOddNumber(AnalyzedNumber);
        Analyze.getEvenNumber(AnalyzedNumber);
        Analyze.getPerfectSquare(AnalyzedNumber);
        Analyze.getUpperCase(input, AnalyzedString);
        Analyze.getLowerCase(input, AnalyzedString);
        Analyze.getSpecialChar(input, AnalyzedString);
        
        // Step 4: Display result
        Analyze.displayResult(input, AnalyzedNumber, AnalyzedString);
        
    }
    
}
