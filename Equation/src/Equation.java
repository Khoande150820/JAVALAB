
import java.util.ArrayList;

/**
 *
 * @author eldee
 */
public class Equation {

    static void superlativeEquation() {
        float a = Validate.getCoef("A");
        float b = Validate.getCoef("B");
        ArrayList<Float> oddNumber = new ArrayList<>();
        ArrayList<Float> evenNumber = new ArrayList<>();
        ArrayList<Float> perfectSquareNumber = new ArrayList<>();
        ArrayList<Float> numberList = new ArrayList<>();
        numberList.add(a);
        numberList.add(b);
        if (a == 0 && b == 0) {
            System.out.println("Solution: Infinite solutions");
        } else if (a == 0 && b != 0) {
            System.out.println("Solution: No solution");
        } else {
            float solution = -b / a;
            System.out.println("Solution: " + solution);
            numberList.add(solution);
        }
        for (float number : numberList) {
            if (Validate.isEven(number)) {
                evenNumber.add(number);
            }
            if (!Validate.isEven(number)) {
                oddNumber.add(number);
            }
            if (Validate.isPerfectSquare(number)) {
                perfectSquareNumber.add(number);
            }
        }

        System.out.print("Number is odd: ");
        displayList(oddNumber);
        System.out.print("Number is even: ");
        displayList(evenNumber);
        System.out.print("Number is Perfect square: ");
        displayList(perfectSquareNumber);
    }

    static void quadraticEquation() {
        ArrayList<Float> oddNumber = new ArrayList<>();
        ArrayList<Float> evenNumber = new ArrayList<>();
        ArrayList<Float> perfectSquareNumber = new ArrayList<>();
        ArrayList<Float> numberList = new ArrayList<>();
        float a = Validate.getCoef("A");
        float b = Validate.getCoef("B");
        float c = Validate.getCoef("C");
        numberList.add(a);
        numberList.add(b);
        numberList.add(c);
        if (a == 0) {
            if (b == 0 && c == 0) {
                System.out.println("Solution: Infinite solution");
            } else if (b == 0 && c != 0) {
                System.out.println("Solution: No solution");
            } else if (b != 0 && c != 0) {
                float solution = -b / c;
                System.out.println("Solution: " + solution);
                numberList.add(solution);
            }
        } else {
            float delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Solution: no solution");
            } else if (delta == 0) {
                float solution = -b / (2 * a);
                System.out.println("Solution: " + solution);
                numberList.add(solution);
            } else {
                float solution1 = (-b - (float) Math.sqrt(delta)) / (2 * a);
                float solution2 = (-b + (float) Math.sqrt(delta)) / (2 * a);
                System.out.println("Solution: " + solution1 + ", " + solution2);
                numberList.add(solution1);
                numberList.add(solution2);
            }
        }
        for (float number : numberList) {
            if (Validate.isEven(number)) {
                evenNumber.add(number);
            }
            if (!Validate.isEven(number)) {
                oddNumber.add(number);
            }
            if (Validate.isPerfectSquare(number)) {
                perfectSquareNumber.add(number);
            }
        }

        System.out.print("Number is odd: ");
        displayList(oddNumber);
        System.out.print("Number is even: ");
        displayList(evenNumber);
        System.out.print("Number is Perfect square: ");
        displayList(perfectSquareNumber);
    }

    static void displayList(ArrayList<Float> numList) {
        if (numList.isEmpty()) {
            System.out.println("No number!");
            return;
        } else {
            int count = 0;
            for (float num : numList) {
                if (count < numList.size() - 1) {
                    System.out.print(num + " ,");
                    count++;
                } else {
                    System.out.println(num);
                }
            }
        }
    }
}
