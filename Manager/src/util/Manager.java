package util;


public class Manager {

    public static int menu() {

        System.out.println("1. Add worker");
        System.out.println("2. Up worker");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.validateIntLimit(1, 5);
        return choice;
    }
}
