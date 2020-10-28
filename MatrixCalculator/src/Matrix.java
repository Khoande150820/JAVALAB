
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
        int row2 = matrix1[0].length;
        int col1 = matrix2.length;
        int col2 = matrix2[0].length;

        if (row2 != col1) {
            System.out.println("Can't multiply");
            return;
        }
        int[][] result = new int[row1][col2];
        // Iterate over rows of the resulting matrix
        for (int i = 0; i < row1; i++) {
            // Iterate over each entry in the resulting matrix
            for (int j = 0; j < col2; j++) {
                System.out.print("[");
                // Assign each entry the dot product between row i of first matrix and column j of second matrix
                for (int k = 0; k < row2; k++) {
                    System.out.print(matrix1[i][k] + "*" + matrix2[k][j]);
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                    System.out.print("+");
                }
                System.out.print("]");
            }
            System.out.println("");
        }

        printMatrix(matrix1);
        System.out.println("x");
        printMatrix(matrix2);
        System.out.println("=");
        printMatrix(result);

    }
}
