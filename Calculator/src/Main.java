
/**
 *
 * @author eldee
 */
public class Main {

    public static void main(String[] args) {
        
        System.out.println("====Calculator Shape Program======");
        // Step 1: Input Rectangle
        Rectangle rectangle = Manage.getRectangle();
        // Step 2: Input Circle
        Circle circle = Manage.getCircle();
        // Step 3: Input Triangle
        Triangle triangle = Manage.getTriangle();
        // Step 4: Display Result
        Manage.display(rectangle, circle, triangle);
        
    }
    
}
