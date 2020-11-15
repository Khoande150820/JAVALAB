
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class Analyze {

    static int[] getNumber(String input) {

        // replace all non digit character with comma
        String number = input.replaceAll("\\D+", ",");
        if (number.charAt(0) == ',') {
            number = number.substring(1);
        }
        if (number.charAt(number.length() - 1) == ',') {
            number = number.substring(0, number.length() - 1);
        }

        String[] numberListString = number.split(",");
        int[] numberList = new int[numberListString.length];
        for (int i = 0; i < numberListString.length; i++) {
            numberList[i] = Integer.parseInt(numberListString[i]);
        }
        return numberList;
    }

    static void getOddNumber(int[] input) {
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (!Validate.isEven(input[i])) {
                oddList.add(input[i]);
            }
        }
        printList(oddList);
    }

    static void getEvenNumber(int[] input) {
        ArrayList<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (Validate.isEven(input[i])) {
                evenList.add(input[i]);
            }
        }
        printList(evenList);
    }

    static void getPerfectSquare(int[] input) {
        ArrayList<Integer> perfectSquareList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (Validate.isPerfectSquare(input[i])) {
                perfectSquareList.add(input[i]);
            }
        }
        printList(perfectSquareList);
    }

    static void getUpperCase(String input) {
        input = input.replaceAll("\\W[0-9][a-z]", "");
        System.out.println(input);
    }

    static void getLowerCase(String input) {
        input = input.replaceAll("\\W[0-9][A-Z]", "");
        System.out.println(input);
    }

    static void getSpecialChar(String input) {
        input = input.replaceAll("\\w", "");
        System.out.println(input);
    }

    static void printList(ArrayList<Integer> intList) {
        if (intList.size() == 0) {
            System.out.println("No number");
            return;
        }
        int[] intArray = new int[intList.size()];
        int i = 0;
        for (int number : intList) {
            intArray[i] = number;
            i++;
        }
        System.out.println(Arrays.toString(intArray));
    }

}
