package task7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    @Test
    @DisplayName("Smoking test")
    public void test() {
        assertArrayEquals(new double[] {1,2,3.3,4,5}, Sorter.Sort(new double[] {3.3,4,1,2,5}));
    }

    @Test
    @DisplayName("Sorted array")
    public void test2() {
        double[] expected = new double[] {1, 2, 3, 4, 5};
        assertArrayEquals(expected, Sorter.Sort(expected));
    }

    @Test
    @DisplayName("Sorted array in dec mode")
    public void test3() {
        double[] expected = new double[] {5, 4, 3, 2, 1};
        assertArrayEquals(new double[] {1,2,3,4,5}, Sorter.Sort(expected));
    }
}