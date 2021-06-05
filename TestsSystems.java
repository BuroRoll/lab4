import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestsSystems {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void correctSolutionsTest() {
        double[][] k = {
                {1, 7, 3},
                {-4, 9, 4},
                {0, 3, 2},
        };
        double[] f = {-1, 0, 6};
        assertArrayEquals(new double[]{0, -4, 9}, Systems.solveSystem(k, f));
    }

    @Test
    public void testNoSolutions(){
        double[][] k = {
                {2, -1, 3},
                {3, -5, 1},
                {4, -7, 1},
        };
        double[] f = {9, -4, 5};
        Systems.solveSystem(k, f);
        assertEquals("Cистема не имеет решений или имеет множество решений", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testNoSolutions2() {
        double[][] k = {
                {1, 2, -3, 5},
                {1, 3, -13, 22},
                {3, 5, 1, -2},
                {2, 3, 4, -7},
        };
        double[] f = {1, -1, 5, 4};
        Systems.solveSystem(k, f);
        assertEquals("Cистема не имеет решений или имеет множество решений", outputStreamCaptor.toString()
                .trim());
    }
}
