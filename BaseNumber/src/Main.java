
public class Main {

    public static void main(String[] args) { //loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                   Manager.decHandle();
                    break;
                case 2:
                    Manager.binaryHandle();
                    break;
                case 3:
                    Manager.hexHandle();
                    break;
                case 4:
                    return;
            }
        }
    }
}

