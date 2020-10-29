
/**
 *
 * @author eldee
 */
public class Fruit {

    private String fruitID;
    private String fruitname;
    private Double fruitPrice;
    private int fruitQuantity;
    private String fruitOrigin;

    public Fruit() {
    }

    public Fruit(String fruitID, String fruitname, Double fruitPrice, int fruitQuantity, String fruitOrigin) {
        this.fruitID = fruitID;
        this.fruitname = fruitname;
        this.fruitPrice = fruitPrice;
        this.fruitQuantity = fruitQuantity;
        this.fruitOrigin = fruitOrigin;
    }

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitname() {
        return fruitname;
    }

    public void setFruitname(String fruitname) {
        this.fruitname = fruitname;
    }

    public Double getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(Double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    public String getFruitOrigin() {
        return fruitOrigin;
    }

    public void setFruitOrigin(String fruitOrigin) {
        this.fruitOrigin = fruitOrigin;
    }
    
    
}
