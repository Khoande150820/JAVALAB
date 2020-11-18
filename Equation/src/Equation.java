
import java.util.ArrayList;

/**
 *
 * @author eldee
 */
public class Equation {

    static ArrayList<Float> calculateSuperlativeEquation(float a, float b) {
        ArrayList<Float> solution = new ArrayList<>();
        if (a == 0) {
            if (b != 0) {
                System.out.println("Solution: No solution");
                solution.add(null);
                return solution;
            } else {
                System.out.println("Solution: infinitely many solution");
                return solution;
            }
        } else {
            float result = -b / a;
            System.out.println("Solution: x = " + result);
            solution.add(result);
            return solution;
        }
    }

    static ArrayList<Float> calculateQuadraticEquation(float a, float b, float c) {
        ArrayList<Float> solutionList = new ArrayList<>();
        if (a == 0) {
            return calculateSuperlativeEquation(b, c);
        } else {
            float delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Solution: No solution");
                solutionList.add(null);
                return solutionList;
            } else if (delta == 0) {
                float solution = -b / (2 * a);
                System.out.println("Solution: x1 = " + solution + " and x2 = " + solution);
                solutionList.add(solution);
                return solutionList;
            } else {
                float solution1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
                float solution2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
                System.out.println("Solution: x1 = " + solution1 + " and x2 = " + solution2);
                solutionList.add(solution1);
                solutionList.add(solution2);
                return solutionList;
            }
        }
    }
}
