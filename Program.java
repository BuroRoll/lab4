import java.util.ArrayList;
import java.util.Scanner;



public class Program {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Вычислить определитель");
        System.out.println("2. Вычислить обратную матрицу");
        System.out.println("3. Умножить матрицу на вектор");
        System.out.println("4. Решить систему линейных уравнений методом обратной матрицы");
        String chose = scanner.next();
        switch (chose) {
            case "1" -> findDet();
            case "2" -> invertMatrix();
            case "3" -> multiplyOnVector();
            case "4" -> solveSystem();
        }
    }

    private static void findDet() {
        double[][] matrix = Matrix.readMatrix();
        System.out.println("Определитель равен " + Matrix.det(matrix));
    }

    private static void invertMatrix() {
        double[][] matrix = Matrix.readMatrix();
        double[][] inverseMatrix = Matrix.inverse(matrix);
        System.out.println("Обратная матрица:");
        for (double[] doubles : inverseMatrix) {
            for (int j = 0; j < inverseMatrix[0].length; j++)
                System.out.print(doubles[j] + " ");
            System.out.println();
        }
    }

    private static void multiplyOnVector() {
        double[][] matrix = Matrix.readMatrix();
        double[] vector = Matrix.readVector();
        double[] solve = Matrix.multiplyOnVector(matrix, vector);
        System.out.println("Результат умножения:");
        for (double v : solve)
            System.out.println(v);
    }

    private static void solveSystem() {
        ArrayList<Object> system = Systems.readSystem();
        double[][] matrix = (double[][]) system.get(0);
        double[] freeElements = (double[]) system.get(1);
        double[] solve = Systems.solveSystem(matrix, freeElements);
        System.out.println("Решение системы:");
        if (solve != null)
            for (int i = 1; i <= solve.length; i++)
                System.out.println("X"+i+" = "+solve[i-1]);
    }
}

