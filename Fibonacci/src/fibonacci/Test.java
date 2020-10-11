package fibonacci;

/**
 *
 * @author eldee
 */
public class Test {

    public static int fibonacci(int numTerm, int preTerm, int nextTerm, int count) {
        if (numTerm < 2) {
            System.out.print(preTerm);
            System.out.println(", " + count);
            return preTerm;
        }
        System.out.print(preTerm + ", ");
        System.out.println(count);
        //recursive
        return fibonacci(numTerm - 1, preTerm + nextTerm, preTerm, count + 1);
    }

    public static void main(String[] args) {
        fibonacci(5, 0, 1, 1);
    }

}
