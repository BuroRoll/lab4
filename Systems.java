import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Systems {

    private static final Scanner scanner = new Scanner(System.in);

    public static ArrayList<Object> readSystem() {
        System.out.println("Введите размер системы");
        int size = scanner.nextInt();
        double[][] matrix = new double[size][size];
        double[] freeElements = new double[size];
        System.out.println("Введите коэффициенты при неизвесных и свободные члены");
        IntStream.range(0, size).forEach(i -> IntStream.range(0, size + 1).forEach(j -> {
            if (j == size)
                freeElements[i] = scanner.nextInt();
            else
                matrix[i][j] = scanner.nextInt();

        }));
        ArrayList<Object> result = new ArrayList<>();
        result.add(matrix);
        result.add(freeElements);
        return result;
    }

    public static double[] solveSystem(double[][] matrix, double[] freeElements) {
        if (Matrix.det(matrix) == 0) {
            System.out.println("Cистема не имеет решений или имеет множество решений");
            return null;
        }
        return Matrix.multiplyOnVector(Matrix.inverse(matrix), freeElements);
    }
}
