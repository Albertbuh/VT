package task6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    public void test() {
        Matrix m = new Matrix(new int[] {1,2,3,4,5});
        int[][] expected = new int[][] {
                {1,2,3,4,5},
                {2,3,4,5,1},
                {3,4,5,1,2},
                {4,5,1,2,3},
                {5,1,2,3,4},

        };
        m.print();
        assertArrayEquals(expected, m.get());
    }
}