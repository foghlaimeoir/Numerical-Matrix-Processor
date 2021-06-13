import java.math.BigInteger;
import java.util.Scanner;

class Matrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.println("1. Add Matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose a matrix");
            System.out.println("5. Calculate a determinant");
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
                case 4: {
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");

                    int option = scanner.nextInt();
                    System.out.print("Enter matrix size: ");
                    int rows = scanner.nextInt();
                    int cols = scanner.nextInt();

                    System.out.println("Enter the matrix to be transposed:");

                    double[][] inputMatrix = readMatrix(scanner, rows, cols);

                    double[][] transposedMatrix = transpose(inputMatrix, option);
                    System.out.print("The result is:");
                    printMatrix(transposedMatrix);
                    break;
                }

                case 5: {
                    System.out.print("Enter matrix size: ");

                    int rows = scanner.nextInt();
                    int cols = scanner.nextInt();

                    System.out.println("Enter matrix:");

                    double[][] inputMatrix = readMatrix(scanner, rows, cols);

                    double determinant = determinant(inputMatrix);
                    System.out.println("The determinant is:");
                    System.out.println(determinant);

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

    public static double[][] transpose(double[][] matrix, int transposition) {
        double[][] transposedMatrix = new double[matrix.length][matrix[0].length];
        switch (transposition) {
            case 1: {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (i == j) {
                            transposedMatrix[i][j] = matrix[i][j];
                            continue;
                        }
                        transposedMatrix[i][j] = matrix[j][i];
                    }
                }
                break;
            }
            case 2: {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (i + j == matrix.length-1) {
                            transposedMatrix[i][j] = matrix[i][j];
                            continue;
                        }
                        transposedMatrix[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1- i];
                    }
                }
                break;
            }
            case 3: {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        transposedMatrix[i][j] = matrix[i][matrix.length - 1 - j];
                    }
                }
                break;
            }
            case 4: {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        transposedMatrix[i][j] = matrix[matrix.length - 1 - i][j];
                    }
                }
                break;
            }

        }
        return transposedMatrix;
    }

    public static double determinant(double[][] matrix) {
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {

            double total = 0;
            int sign = 1;

            for (int i = 0; i < matrix.length; i++) {
                double[][] minor = minor(matrix, 0, i);
                total += sign * matrix[0][i] * determinant(minor);
                sign = -sign;
            }

            return total;
        }
    }

    public static double[][] minor(double[][] matrix, int inputRow, int inputCol) {
        double[][] minor = new double[matrix.length-1][matrix.length-1];

        int outputRow = 0;
        int outputCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != inputRow && j != inputCol) {
                    minor[outputRow][outputCol++] = matrix[i][j];

                    if (outputCol == minor.length) {
                        outputCol = 0;
                        outputRow++;
                    }
                }
            }
        }
        return minor;
    }
}
