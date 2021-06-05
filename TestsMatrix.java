import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class TestsMatrix {
    @Test
    public void SuccessCalcDet() {
        double[][] matrix = {
                {1, -2, 3},
                {4, 0, 6},
                {-7, 8, 9}
        };
        assertEquals(204, Matrix.det(matrix));
    }

    @Test
    public void ZeroDet() {
        double[][] matrix = {
                {11, 22, 33},
                {11, 22, 33},
                {22, 44, 66}
        };
        assertEquals(0, Matrix.det(matrix));
    }

    @Test
    public void SmallMatrixDet() {
        double[][] matrix = {
                {10},
        };
        assertEquals(10, Matrix.det(matrix));
    }

    @Test
    public void MultiplyOnVectorTest() {
        double[][] matrix = {
                {2, 4, 0},
                {-2, 1, 3},
                {-1, 0, 1}
        };
        double[] vector = {1, 2, -1};
        double[] expect = {10, -3, -2};
        assertArrayEquals(expect, Matrix.multiplyOnVector(matrix, vector));
    }

    @Test
    public void MultiplyOnVectorTest2() {
        double[][] matrix = {
                {2, -3},
                {4, 7},
        };
        double[] vector = {2, 3};
        double[] expect = {-5, 29};
        assertArrayEquals(expect, Matrix.multiplyOnVector(matrix, vector));
    }

    @Test
    public void InverseMatrixTest() {
        double[][] matrix = {
                {2, 5, 7},
                {6, 3, 4},
                {5, -2, -3}
        };
        double[][] expect = {
                {1, -1, 1},
                {-38, 41, -34},
                {27, -29, 24}
        };
        assertArrayEquals(expect, Matrix.inverse(matrix));
    }

    @Test
    public void InverseMatrixTest2() {
        double[][] matrix = {
                {7, 4},
                {5, 3},
        };
        double[][] expect = {
                {3, -4},
                {-5, 7},
        };
        assertArrayEquals(expect, Matrix.inverse(matrix));
    }
}