
public class Manager {

    public static int menu() {
        System.out.println("Enter base you want to convert from:");
        System.out.println("1. Convert from decimal");
        System.out.println("2. Convert from binary");
        System.out.println("3. Convert from hexadecimal");
        System.out.println("4. Exit program");
        System.out.print("Enter your choice: ");
        int selection = Validate.validateInteger(1, 4);
        return selection;
    }

    
    
    
    // Binary submenu
    public static int binaryMenu(){
        System.out.println("");
    }
}
