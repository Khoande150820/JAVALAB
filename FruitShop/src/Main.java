
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;


public class Main {

    public static void main(String[] args) throws IOException {
        // Loop until user select exit
        ArrayList<Fruit> fruitList = Manager.loadFruitList();
        Hashtable<String, ArrayList<Fruit>> orderTable = new Hashtable<>();
        while(true){
            int choice = Manager.menu();
            switch(choice){
                case 1:
                    Manager.createFruit(fruitList);
                    break;
                case 2:
                    Manager.viewOrder(orderTable);
                    break;
                case 3:
                    Manager.shopping(fruitList, orderTable);
                    break;
                case 4:
                    Manager.saveFruitList(fruitList);
                    return;
            }
        }
    }
    
}
