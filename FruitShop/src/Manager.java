
public class Manager {

    static int menu() {
        System.out.println("");
        System.out.println("");
        System.out.println("---------------");
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
        return Validate.getInputByLimit(1, 4);
    }

}
