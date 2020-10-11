package fibonacci;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci: ");
        displayFibonacci(10,0,1,1);
        
    }
    
    static int displayFibonacci(int term, int currentTerm, int preTerm, int count) {

        if (term < 2) {
            System.out.print(currentTerm + " ,");
            System.out.println(count);
            return currentTerm;
        }
        System.out.print(currentTerm + " ,");
        System.out.println(count);
        return displayFibonacci(term - 1, currentTerm + preTerm, currentTerm, count -1);
    }
    
}
