
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Manager {

    static ArrayList<Fruit> loadFruitList() throws IOException {
        try {
            ArrayList<Fruit> fruitList = new ArrayList<>();
            FileReader fr = new FileReader("fruitList.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null && line.length() != 0) {
                String[] arrOfString = line.split(";");
                String id = arrOfString[0].trim();
                String name = arrOfString[1].trim();
                double price = Double.parseDouble(arrOfString[2].trim());
                int quantity = Integer.parseInt(arrOfString[3].trim());
                String origin = arrOfString[4];
                fruitList.add(new Fruit(origin, name, price, quantity, origin));
            }
            br.close();
            return fruitList;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    static void saveFruitList(ArrayList<Fruit> fruitList) throws IOException {
        FileWriter fw = new FileWriter("fruitList.txt");
        PrintWriter pw = new PrintWriter(fw);
        for (Fruit fruit : fruitList) {
            pw.println(fruit.getFruitID() + ";" + fruit.getFruitname() + ";" + fruit.getFruitPrice() + ";" + fruit.getFruitQuantity() + ";" + fruit.getFruitOrigin());
        }
        pw.close();
    }

    static Hashtable<String, ArrayList<Fruit>> loadOrderList(ArrayList<Fruit> fruitList) throws IOException {
        Hashtable<String, ArrayList<Fruit>> orderList = new Hashtable<>();
        FileReader fr = new FileReader("order.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] arrOfString = line.split(";");
            String name = arrOfString[0];
            if (!orderList.containsKey(name)) {
                ArrayList<Fruit> fruitOrder = new ArrayList<>();
                String fruitID = arrOfString[1];
                Fruit f = findByID(fruitList, fruitID);
                String fruitName = f.getFruitname();
                int quantity = Integer.parseInt(arrOfString[2]);
                String fruitOrigin = f.getFruitOrigin();
                double price = f.getFruitPrice();
                fruitOrder.add(new Fruit(fruitID, fruitName, price, quantity, fruitOrigin));
            } else {
                ArrayList<Fruit> fruitOrder = orderList.get(name);
                String fruitID = arrOfString[1];
                Fruit f = findByID(fruitList, fruitID);
                String fruitName = f.getFruitname();
                int quantity = Integer.parseInt(arrOfString[2]);
                String fruitOrigin = f.getFruitOrigin();
                double price = f.getFruitPrice();
                fruitOrder.add(new Fruit(fruitID, fruitName, price, quantity, fruitOrigin));
            }
        }
        return orderList;
    }

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

    static Fruit findByID(ArrayList<Fruit> fruitList, String id) {
        for (Fruit f : fruitList) {
            if (f.getFruitID().equalsIgnoreCase(id)) {
                return f;
            }
        }
        return null;
    }

    static void createFruit(ArrayList<Fruit> fruitList) {
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validate.getInputString();
            if (Validate.checkIdExist(fruitList, fruitId)) {
                System.err.println("Id already exist in list!");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validate.getInputString();
            System.out.print("Enter price: ");
            double price = Validate.getPositiveDouble();
            System.out.print("Enter Quantity: ");
            int quantity = Validate.getPositiveInt();
            System.out.print("Enter origin: ");
            String origin = Validate.getInputString();
            fruitList.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            System.out.print("Do you want to continue (Y/N)?: ");
            if (!Validate.getInputYN()) {
                return;
            }
        }
    }

    static void displayFruitList(ArrayList<Fruit> fruitList) {
        int item = 1;
        System.out.println("List of fruit:");
        System.out.printf("%-15s%-15s%-15s%-5s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit f : fruitList) {
            if (f.getFruitQuantity() > 0) {
                System.out.printf("%-15d%-15s%-15s%-5.0f$\n", item, f.getFruitname(), f.getFruitOrigin(), f.getFruitPrice());
                item++;
            }
        }
    }

    static void displayOrderedList(ArrayList<Fruit> orderedList) {
        System.out.printf("%-15s%-15s%-15s%-5s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : orderedList) {
            double amount = fruit.getFruitQuantity() * fruit.getFruitPrice();
            System.out.printf("%-15s%-15d%-15.0f%-15.0f\n", fruit.getFruitname(), fruit.getFruitQuantity(), fruit.getFruitPrice(), amount);
        }
    }

    static void viewOrder(Hashtable<String, ArrayList<Fruit>> orderedTable) {
        for (String name : orderedTable.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Fruit> order = orderedTable.get(name);
            displayOrderedList(order);
        }
    }

    static Fruit getFruitByItem(int item, ArrayList<Fruit> fruitList) {
        int itemCount = 0;
        for (Fruit fruit : fruitList) {
            if (fruit.getFruitQuantity() > 0) {
                itemCount++;
            }
            if (item == itemCount) {
                return fruit;
            }
        }
        return null;
    }

    static void shopping(ArrayList<Fruit> fruitList, Hashtable<String, ArrayList<Fruit>> orderTable) {
        ArrayList<Fruit> orderedFruit = new ArrayList<>();
        while (true) {
            displayFruitList(fruitList);
            System.out.print("Enter item: ");
            int item = Validate.getInputByLimit(1, fruitList.size());
            Fruit fruit = getFruitByItem(item, fruitList);
            System.out.println("You selected: " + fruit.getFruitname());
            System.out.println("Please input quantity");
            int quantity = Validate.getInputByLimit(1, fruit.getFruitQuantity());
            fruit.setFruitQuantity(fruit.getFruitQuantity() - quantity);
            orderedFruit.add(new Fruit(fruit.getFruitID(), fruit.getFruitname(), fruit.getFruitPrice(), quantity, fruit.getFruitOrigin()));
            System.out.print("Do you want to order now (Y/N): ");
            if (Validate.getInputYN()) {
                displayOrderedList(orderedFruit);
                double totalAmount = 0;
                for (Fruit f : orderedFruit) {
                    totalAmount += f.getFruitPrice() * f.getFruitQuantity();
                }
                System.out.println("Total amount: " + totalAmount);
                System.out.print("Input your name: ");
                String name = Validate.getInputString();
                orderTable.put(name, orderedFruit);
                return;
            }
        }
    }
}
