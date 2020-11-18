
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("======Equation program========");
            ArrayList<Float> solution;
            float a, b, c;
            int choice = menu();
            switch (choice) {
                case 1:
                    System.out.println("-------Calculate Equation---------");
                    a = Validate.getCoef("A");
                    b = Validate.getCoef("B");
                    solution = Equation.calculateSuperlativeEquation(a, b);
                    displayClassification(a, b, solution);
                    break;
                case 2:
                    System.out.println("-------Calculate Quadratic Equation ---------");
                    a = Validate.getCoef("A");
                    b = Validate.getCoef("B");
                    c = Validate.getCoef("C");
                    solution = Equation.calculateQuadraticEquation(a, b, c);
                    displayClassification(a, b, c, solution);
                    break;
                case 3:
                    System.out.println("Exiting...................");
                    return;
            }
        }
    }

    static int menu() {
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
        return Validate.getInputByLimit(1, 3);
    }

    static void displayList(ArrayList<Float> numberList) {
        if(numberList.isEmpty()){
            System.out.println("None");
        }
        int i = 0;
        for (Float f : numberList) {
            if (i != numberList.size() - 1) {
                System.out.print(f + ", ");
                i++;
            } else {
                System.out.println(f);
            }

        }
    }

    static void displayClassification(float a, float b, ArrayList<Float> solutionList) {
        ArrayList<Float> allNumber = new ArrayList<>();
        ArrayList<Float> oddNumber = new ArrayList<>();
        ArrayList<Float> evenNumber = new ArrayList<>();
        ArrayList<Float> perfectSquareNumber = new ArrayList<>();
        allNumber.add(a);
        allNumber.add(b);
        for (Float f : solutionList) {
            if (f != null) {
                allNumber.add(f);
            }
        }

        for (Float f : allNumber) {
            if (!Validate.isEven(f)) {
                oddNumber.add(f);
            } else {
                evenNumber.add(f);
            }
        }

        for (Float f : allNumber) {
            if (Validate.isPerfectSquare(f)) {
                perfectSquareNumber.add(f);
            }
        }

        System.out.print("Odd number(s): ");
        displayList(oddNumber);
        System.out.print("Even number(s): ");
        displayList(evenNumber);
        System.out.print("Perfect square number(s): ");
        displayList(perfectSquareNumber);
    }

    static void displayClassification(float a, float b, float c, ArrayList<Float> solutionList) {
        ArrayList<Float> allNumber = new ArrayList<>();
        ArrayList<Float> oddNumber = new ArrayList<>();
        ArrayList<Float> evenNumber = new ArrayList<>();
        ArrayList<Float> perfectSquareNumber = new ArrayList<>();
        allNumber.add(a);
        allNumber.add(b);
        allNumber.add(c);
        for (Float f : solutionList) {
            if (f != null) {
                allNumber.add(f);
            }
        }

        for (Float f : allNumber) {
            if (!Validate.isEven(f)) {
                oddNumber.add(f);
            } else {
                evenNumber.add(f);
            }
        }

        for (Float f : allNumber) {
            if (Validate.isPerfectSquare(f)) {
                perfectSquareNumber.add(f);
            }
        }

        System.out.print("Odd number(s): ");
        displayList(oddNumber);
        System.out.print("Even number(s): ");
        displayList(evenNumber);
        System.out.print("Perfect square number(s): ");
        displayList(perfectSquareNumber);
    }

}
