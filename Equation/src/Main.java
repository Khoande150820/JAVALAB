
/**
 *
 * @author eldee
 */
public class Main {

    static int menu() {
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
        return Validate.getInputByLimit(1, 3);
    }

    public static void main(String[] args) {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    System.out.println("-----Calculate Equation-----");
                    Equation.superlativeEquation();
                    break;
                case 2:
                    System.out.println("-----Calculate Quadratic Equation------");
                    Equation.quadraticEquation();
                    break;
                case 3:
                    return;
            }

        }

    }

}
