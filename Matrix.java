import java.util.Scanner;
import java.util.stream.IntStream;

public class Matrix {
    private static final Scanner scanner = new Scanner(System.in);

    static double[][] readMatrix() {
        System.out.println("Введите размерность матрицы");
        int size = scanner.nextInt();
        double[][] matrix = new double[size][size];
        System.out.println("Введите матрицу");
        IntStream.range(0, size)
                .forEach(i -> IntStream.range(0, size)
                        .forEach(j -> matrix[i][j] = scanner.nextInt()));
        return matrix;
    }

    static double[] readVector() {
        System.out.println("Введите размер вектора");
        int size = scanner.nextInt();
        double[] vector = new double[size];
        System.out.println("Введите векторm");
        for (int i = 0; i < size; i++) {
            vector[i] = scanner.nextDouble();
        }
        return vector;
    }

    static double det(double[][] matrix) {
        int n = matrix.length;
        if (n == 1)
            return matrix[0][0];
        if (n == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        double result = 0;
        double[][] minor = new double[n - 1][n - 1];

        int l = 1;
        for (int i = 0; i < n; ++i) {
            int x = 0;
            int y = 0;
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == k) continue;
                    minor[x][y] = matrix[j][k];
                    y++;
                    if (y == n - 1) {
                        y = 0;
                        x++;
                    }
                }
            }
            result += l * matrix[0][i] * det(minor);
            l *= -1;
        }
        return result;
    }


    static double[][] inverse(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j)
                        * Matrix.det(minor(matrix, i, j));
        double det = 1.0 / Matrix.det(matrix);
        inverse = Matrix.transpose(inverse);
        for (int i = 0; i < inverse.length; i++)
            for (int j = 0; j <inverse.length; j++)
                inverse[i][j] = inverse[i][j] * det;
        return inverse;
    }

    static double[] multiplyOnVector(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix[0].length; j++)
                sum += matrix[i][j] * vector[j];
            result[i] = sum;
        }
        return result;
    }

    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix.length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

    private static double[][] transpose(double[][] matrix) {
        double[][] transpose = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }
}
