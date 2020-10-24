
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
    public static void binaryHandle() {
        System.out.println("Binary Menu");
        String bin = Validate.getBinary();
        System.out.println("1. Binary to decimal");
        System.out.println("2. Binary to hexadecimal");
        System.out.print("Enter your choice: ");

        int selection = Validate.validateInteger(1, 2);
        switch (selection) {
            case 1:
                System.out.println("Decimal: " + Convert.convertBinToDec(bin));
                break;
            case 2:
                long dec = Convert.convertBinToDec(bin);
                System.out.println("Hexadecimal: " + Convert.convertDecToHex(dec));
                break;
        }
    }

    public static void decHandle() {
        System.out.println("Decimal Menu");
        long dec = Validate.getDecimal();
        System.out.println("1. Decimal to binary");
        System.out.println("2. Decimal to hexadecimal");
        System.out.print("Enter your choice: ");
        int selection = Validate.validateInteger(1, 2);
        switch (selection) {
            case 1:
                System.out.println("Binary: " + Convert.convertDecToBin(dec));
                break;
            case 2:
                System.out.println("Hexadecimal: " + Convert.convertDecToHex(dec));
                break;
        }
    }

    public static void hexHandle() {
        System.out.println("Hexadecimal Menu");
        String hex = Validate.getHex();
        System.out.println("1. Hexadecimal to binary");
        System.out.println("2. Hexadecimal to Decimal");
        System.out.print("Enter your choice: ");
        int selection = Validate.validateInteger(1, 2);
        switch (selection) {
            case 1:
                long dec = Convert.convertHexToDec(hex);
                System.out.println("Binary: " + Convert.convertDecToBin(dec));
                break;
            case 2:
                System.out.println("Decimal: " + Convert.convertHexToDec(hex));
                break;
        }
    }
}
