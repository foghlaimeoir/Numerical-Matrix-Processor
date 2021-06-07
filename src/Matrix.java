import java.util.Scanner;

class Matrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstRows = scanner.nextInt();
        int firstCols = scanner.nextInt();

        int[][] firstMatrix = new int[firstRows][firstCols];

        for (int i = 0; i < firstRows; i++) {
            for (int j = 0; j < firstCols; j++) {
                firstMatrix[i][j] = scanner.nextInt();
            }
        }

        int secondRows = scanner.nextInt();
        int secondCols = scanner.nextInt();

        if (firstRows != secondRows || firstCols != secondCols) {
            System.out.println("ERROR");
            return;
        }

        int[][] secondMatrix = new int[firstRows][firstCols];

        for (int i = 0; i < firstRows; i++) {
            for (int j = 0; j < firstCols; j++) {
                secondMatrix[i][j] = scanner.nextInt();
            }
        }

        int[][] addedMatrix = addition(firstMatrix, secondMatrix);

        for (int i = 0; i < firstRows; i++) {
            System.out.println("");
            for (int j = 0; j < firstCols; j++) {
                System.out.print(addedMatrix[i][j] + " ");
            }
        }
    }

    public static int[][] addition(int[][] matrix1, int[][] matrix2) {
        int[][] addedMatrix = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                addedMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return addedMatrix;
    }
}
