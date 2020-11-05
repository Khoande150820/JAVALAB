
import java.util.ArrayList;


public class Managager {
    static int menu(){
        System.out.println("1. Add a contact");
        System.out.println("2. Display all contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Exit");
        return Validation.getIntInRange(1, 4);
    }
    
    
    static void addNew(ArrayList<Contact> contactList){
        int id = Validation.getNextId(contactList);
        String name = Validation.getInputString();
        String group = Validation.getInputString();
        String address = Validation.getInputString();
        String phone = Validation.getInputPhone();
    }
    
    
    
}
