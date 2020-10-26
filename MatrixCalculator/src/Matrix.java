
public class Matrix {

    static int[][] getMatrix(int n) {
        System.out.print("Enter row number: ");
        int row = Validate.getPositiveInt();
        System.out.print("Enter column number: ");
        int column = Validate.getPositiveInt();
        int[][] result = new int[row][column];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                System.out.print("Enter matrix" + n + "[" + i + "]" + "[" + j + "]: ");
                result[i - 1][j - 1] = Validate.getNumber();
            }
        }
        return result;
    }

    static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    static void addMatrix() {
        int[][] matrix1 = getMatrix(1);
        int[][] matrix2 = getMatrix(2);

        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            int[][] result = new int[matrix1.length][matrix1[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            printMatrix(matrix1);
            System.out.println("+");
            printMatrix(matrix2);
            System.out.println("=");
            printMatrix(result);
        } else {
            System.out.println("Can't add 2 matrices with different size");
        }
    }

    static void subtract() {
        int[][] matrix1 = getMatrix(1);
        int[][] matrix2 = getMatrix(2);

        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            int[][] result = new int[matrix1.length][matrix1[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }

            printMatrix(matrix1);
            System.out.println("-");
            printMatrix(matrix2);
            System.out.println("=");
            printMatrix(result);
        } else {
            System.out.println("Can't subtract 2 matrices with different size");
        }
    }

    static void multiplication() {
        int[][] matrix1 = getMatrix(1);
        int[][] matrix2 = getMatrix(2);
        int row1 = matrix1.length;
        int col2 = matrix2[0].length;
        if (row1 != col2){
            System.out.println("Can't multiply");
            return;
        }
        int [][] result = new int[row1][col2];
        
        for (int i = 0; i < row1; i++){
            for (int j = 0; j < col2;j++){
                for(int k = 0; k < row1;k++){
                    result[i][k] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        
        printMatrix(matrix1);
        System.out.println("x");
        printMatrix(matrix2);
        System.out.println("=");
        printMatrix(result);
        
    }
}
