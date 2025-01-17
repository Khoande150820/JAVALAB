
import java.util.ArrayList;
import java.util.Scanner;

public class Validate {

    static int getInputByLimit(int min, int max) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int output = Integer.parseInt(sc.nextLine().trim());
                if (output < min || output > max) {
                    System.out.println("Please enter a number between" + min + " and " + max);
                    System.out.print("Enter again: ");
                    continue;
                } else {
                    return output;
                }
            } catch (Exception e) {
                System.err.println("Please enter a number!");
                System.out.print("Enter again: ");
            }
        }
    }

    static String getInputString() {
        // loop until user enter non-empty string
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String output = sc.nextLine();
                if (output.isEmpty()) {
                    System.out.println("Value enter must not be empty");
                    System.out.print("Enter again: ");
                }
                return output;
            } catch (Exception e) {
            }
        }
    }

    static int getPositiveInt() {
        // loop until user enter non-empty positive integer
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String output = sc.nextLine();
                if (output.isEmpty()) {
                    System.out.println("Value enter must not be empty");
                    System.out.print("Enter again");
                    continue;
                } else {
                    int result = Integer.parseInt(output.trim());
                    if (result <= 0) {
                        System.out.println("Please enter a positive number");
                        System.out.print("Enter again: ");
                        continue;
                    } else {
                        return result;
                    }
                }

            } catch (Exception e) {
                System.err.println("Please enter an integer");
                System.out.print("Enter again: ");
            }
        }
    }

    static double getPositiveDouble() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String output = sc.nextLine();
                if (output.isEmpty()) {
                    System.out.println("Value enter must not be empty");
                    System.out.print("Enter again");
                    continue;
                } else {
                    double result = Double.parseDouble(output.trim());
                    if (result <= 0) {
                        System.out.println("Please enter a positive number");
                        System.out.print("Enter again: ");
                        continue;
                    } else {
                        return result;
                    }
                }

            } catch (Exception e) {
                System.err.println("Please enter a number");
                System.out.print("Enter again: ");
            }
        }
    }

    static boolean checkIdExist(ArrayList<Fruit> fruitList, String fruitId) {
        for (Fruit fruit : fruitList) {
            if (fruitId.equalsIgnoreCase(fruit.getFruitID())) {
                return true;
            }
        }
        return false;
    }

    static boolean getInputYN() {
        
        while (true) {
            String result = getInputString();
            if (result.equalsIgnoreCase("y")) {
                return true;
            } else if (result.equalsIgnoreCase("n")){
                return false;
            } else {
                System.out.println("Please input y/Y or n/N");
                System.out.print("Enter again: ");
            }
        }
    }
}