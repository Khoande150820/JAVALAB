
public class Main {

    public static void main(String[] args) { //loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Validate.getBinary();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    return;
            }
        }
    }
}

