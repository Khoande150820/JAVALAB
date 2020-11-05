
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Contact> contactList = new ArrayList<>();
        while (true) {
            int selection = Managager.menu();
            switch (selection) {
                case 1:
                    Managager.addNew(contactList);
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
