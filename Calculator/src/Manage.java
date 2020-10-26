
import java.util.Scanner;

public class Manage {

    static double getPositveNumber() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < 0) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.err.println("Please enter a positive number");
                System.out.print("Enter again: ");
            }
        }
    }

    static Triangle getTriangle() {
        while (true) {
            System.out.println("Please input side A of Triangle:");
            double a = getPositveNumber();
            System.out.println("Please input side B of Triangle:");
            double b = getPositveNumber();
            System.out.println("Please input side C of Triangle:");
            double c = getPositveNumber();
            if (a + b > c && b + c > a && a + c > b) {
                return  new Triangle(a, b, c);
            } else{
                System.out.println("Not a triangle, please re-enter!");
            }
        }
    }
    
    static Rectangle getRectangle(){
        System.out.println("Please input side width of the Rectangle:");
        double width = getPositveNumber();
        System.out.println("Please input length of Rectangle:");
        double length = getPositveNumber();
        return new Rectangle(length, width);
    }
    
    static Circle getCircle(){
        System.out.println("Please input radius of Circle:");
        double radius = getPositveNumber();
        return new Circle(radius);
    }
    
    static void display(Rectangle rectangle, Circle circle, Triangle triangle){
        System.out.println("-----Rectangle-----");
        rectangle.printResult();
        System.out.println("-----Circle-----");
        circle.printResult();
        System.out.println("-----Triangle-----");
        triangle.printResult();
    }
}
