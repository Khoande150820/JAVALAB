
import java.util.ArrayList;

public class Order {

    private String customerName;
    private ArrayList<Fruit> orderedFruit;

    public Order(String customerId, String customerName, ArrayList<Fruit> orderedFruit) {
        this.customerName = customerName;
        this.orderedFruit = orderedFruit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Fruit> getOrderedFruit() {
        return orderedFruit;
    }

    public void setOrderedFruit(ArrayList<Fruit> orderedFruit) {
        this.orderedFruit = orderedFruit;
    }

}
