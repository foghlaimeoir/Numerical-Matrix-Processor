import java.util.Scanner;

class Matrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.println("1. Add Matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("0. Exit");

            System.out.print("Please choose an action: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter the size of first matrix: ");
                    int firstRows = scanner.nextInt();
                    int firstCols = scanner.nextInt();

                    System.out.println("Enter the first matrix:");

                    double[][] firstMatrix = readMatrix(scanner, firstRows, firstCols);

                    System.out.println("Enter the size of second matrix: ");
                    int secondRows = scanner.nextInt();
                    int secondCols = scanner.nextInt();

                    if (firstRows != secondRows || firstCols != secondCols) {
                        System.out.println("ERROR: Matrix sizes must match for addition");
                        return;
                    }

                    System.out.println("Enter the second matrix:");

                    double[][] secondMatrix = readMatrix(scanner, secondRows, secondCols);

                    double[][] addedMatrix = addition(firstMatrix, secondMatrix);
                    System.out.println("The result is:");
                    printMatrix(addedMatrix);
                    break;
                }
                case 2: {
                    System.out.print("Enter the size of the matrix: ");
                    int rows = scanner.nextInt();
                    int cols = scanner.nextInt();

                    System.out.println("Enter the matrix:");

                    double[][] inputMatrix = readMatrix(scanner, rows, cols);

                    System.out.print("Enter constant: ");
                    double constant = scanner.nextDouble();

                    double[][] scaledMatrix = multiplyByConstant(constant, inputMatrix);

                    System.out.println("The result is:");
                    printMatrix(scaledMatrix);
                    break;
                }
                case 3: {
                    System.out.print("Enter the size of first matrix: ");
                    int firstRows = scanner.nextInt();
                    int firstCols = scanner.nextInt();

                    System.out.println("Enter the first matrix:");

                    double[][] firstMatrix = readMatrix(scanner, firstRows, firstCols);

                    System.out.print("Enter the size of second matrix: ");
                    int secondRows = scanner.nextInt();
                    int secondCols = scanner.nextInt();

                    if (firstCols != secondRows) {
                        System.out.println("ERROR: Operation undefined for specified sizes");
                        return;
                    }

                    System.out.println("Enter the second matrix:");

                    double[][] secondMatrix = readMatrix(scanner, secondRows, secondCols);

                    double[][] multipliedMatrix = multiply(firstMatrix, secondMatrix);

                    System.out.print("The result is:");
                    printMatrix(multipliedMatrix);
                    break;
                }
                case 0:
                    exit = true;
            }
        } while (!exit);

    }

    public static double[][] addition(double[][] matrix1, double[][] matrix2) {
        double[][] addedMatrix = new double[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                addedMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return addedMatrix;
    }

    public static double[][] multiply(double[][] matrix1, double[][] matrix2) {
        double[][] multipliedMatrix = new double[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    multipliedMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return multipliedMatrix;
    }

    public static double[][] multiplyByConstant(double constant, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] * constant;
            }
        }
        return matrix;
    }

    public static double[][] readMatrix(Scanner scanner, int rows, int columns) {
        double[][] readMatrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                readMatrix[i][j] = scanner.nextDouble();
            }
        }
        return readMatrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("");
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println("");
    }
}
