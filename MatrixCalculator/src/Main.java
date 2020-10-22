
public class Main {

    public static void main(String[] args) {

        while (true) {
            Manage.menu();
            int choice = Validate.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    System.out.println("------Addition------");
                    Matrix.addMatrix();
                    break;
                case 2:
                    System.out.println("------Subtraction------");
                    Matrix.subtract();
                    break;
                case 3:
                    System.out.println("------Multiplication------");
                    Matrix.multiplication();
                    break;
                case 4:
                    return;
            }

        }

    }

}
