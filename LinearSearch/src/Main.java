
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int getPositiveNum() {

        // Loop until user enter a valid number
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                int arrayLength = Integer.parseInt(sc.nextLine().trim());
                //Return error if arrayLength is not positive
                if (arrayLength <= 0) {
                    System.err.println("Please enter a positive integer!");
                    System.err.println("Please enter again: ");
                } else {
                    return arrayLength;
                }
                // Return error if user enter non-integer value
            } catch (NumberFormatException e) {
                System.err.println("Please enter a positive integer!");
                System.err.println("Please enter again: ");
            } 

        }
    }

    static int[] generateArray(int arrayLength) {
        Random rand = new Random();
        int[] outputArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            outputArray[i] = rand.nextInt(arrayLength);
        }
        return outputArray;
    }

    static void linearSearch(int[] numArray, int searchKey) {
        System.out.println("The array: " + Arrays.toString(numArray));
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == searchKey) {
                System.out.println("Found " + searchKey + " at index " + i);
                return;
            }

        }
        System.out.println("Can't find " + searchKey + " in the array");

    }

    public static void main(String[] args) {
        // Step 1 : Get array length and search key from input
        System.out.println("Please enter number of array: ");
        int arrayLength = getPositiveNum();
        System.out.println("Enter search value");
        int searchKey = getPositiveNum();

        // Step 2: Generate random integer in number range input
        int[] numArray = generateArray(arrayLength);

        // Step 3: Search number in the array and print to screen
        linearSearch(numArray, searchKey);

    }

}
