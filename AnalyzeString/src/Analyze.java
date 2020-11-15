
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Analyze {

    static void getAllNumber(String input, HashMap<String, ArrayList<Integer>> analyzedNumber) {
        ArrayList<Integer> numberList = new ArrayList<>();
        // replace all non digit character with comma
        String number = input.replaceAll("\\D+", ",");
        // Remove the begin and end comma (if has any) in the string
        if (number.length() > 1) {
            if (number.charAt(0) == ',') {
                number = number.substring(1);
            }
            if (number.charAt(number.length() - 1) == ',') {
                number = number.substring(0, number.length() - 1);
            }

            String[] numberListString = number.split(",");

            for (int i = 0; i < numberListString.length; i++) {
                numberList.add(Integer.parseInt(numberListString[i]));
            }
            analyzedNumber.put("All number: ", numberList);
        } else {
            analyzedNumber.put("All number: ", numberList);
        }
    }

    static void getPerfectSquare(HashMap<String, ArrayList<Integer>> analyzedNumber) {
        ArrayList<Integer> perfectSquareList = new ArrayList<>();
        if (!analyzedNumber.isEmpty()) {
            ArrayList<Integer> allNumberList = analyzedNumber.get("All number: ");
            for (int number : allNumberList) {
                if (Validate.isPerfectSquare(number)) {
                    perfectSquareList.add(number);
                }
            }
            analyzedNumber.put("Perfect square", perfectSquareList);
        }
    }

    static void getOddNumber(HashMap<String, ArrayList<Integer>> analyzedNumber) {
        ArrayList<Integer> oddList = new ArrayList<>();
        if (!analyzedNumber.isEmpty()) {
            ArrayList<Integer> allNumberList = analyzedNumber.get("All number: ");
            for (int number : allNumberList) {
                if (!Validate.isEven(number)) {
                    oddList.add(number);
                }
            }
            analyzedNumber.put("Odd number", oddList);
        }
    }

    static void getEvenNumber(HashMap<String, ArrayList<Integer>> analyzedNumber) {
        if (!analyzedNumber.isEmpty()) {
            ArrayList<Integer> evenList = new ArrayList<>();
            ArrayList<Integer> allNumberList = analyzedNumber.get("All number: ");
            for (int number : allNumberList) {
                if (Validate.isEven(number)) {
                    evenList.add(number);
                }
            }
            analyzedNumber.put("Even number", evenList);
        }
    }

    static void getUpperCase(String input, HashMap<String, String> analyzedString) {
        String uppercase = input.replaceAll("\\W|[0-9]|[a-z]", "");
        analyzedString.put("Upper case", uppercase);
    }

    static void getLowerCase(String input, HashMap<String, String> analyzedString) {
        String lowercase = input.replaceAll("\\W|[0-9]|[A-Z]", "");
        analyzedString.put("Lower case", lowercase);
    }

    static void getSpecialChar(String input, HashMap<String, String> analyzedString) {
        String special = input.replaceAll("\\w", "");
        analyzedString.put("Special character", special);
    }

    static void printList(ArrayList<Integer> numberList) {
        if (numberList.size()==0) {
            System.out.println("No result");
            return;
        }
        int[] numArray = new int[numberList.size()];
        int i = 0;
        for (int num : numberList) {
            numArray[i] = num;
            i++;
        }
        System.out.println(Arrays.toString(numArray));
    }

    static void printList(String str) {
        if (str.isEmpty()) {
            System.out.println("No result");
        } else {
            System.out.println(str);
        }
    }

    static void displayResult(String input, HashMap<String, ArrayList<Integer>> analyzedNumber, HashMap<String, String> analyzedString) {
        System.out.println("----Result Analysis------");
        System.out.print("Perfect square number: ");
        printList(analyzedNumber.get("Perfect square"));
        System.out.print("Odd number: ");
        printList(analyzedNumber.get("Odd number"));
        System.out.print("Even number: ");
        printList(analyzedNumber.get("Even number"));
        System.out.print("All number");
        printList(analyzedNumber.get("All number: "));
        System.out.print("Uppercase characters: ");
        printList(analyzedString.get("Upper case"));
        System.out.print("Lowercase characters: ");
        printList(analyzedString.get("Lower case"));
        System.out.print("Special characters: ");
        printList(analyzedString.get("Special character"));
        System.out.print("All characters: ");
        printList(input);
    }

}
