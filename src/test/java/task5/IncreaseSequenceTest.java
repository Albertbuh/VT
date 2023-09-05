package task5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncreaseSequenceTest {

    @Test
    public void test(){
        assertEquals(4, IncreaseSequence.getK(new int[] {30, 40, 2, 5, 1, 7, 45, 50, 8}));
    }

    @Test
    @DisplayName("With negative numbers")
    public void testNegative(){
        assertEquals(4, IncreaseSequence.getK(new int[] {10, 20, -7, 5, -2, 4, 45, 50, -8}));
    }

    @Test
    @DisplayName("Sorted array")
    public void test2(){
        assertEquals(0, IncreaseSequence.getK(new int[] {1,2,3,4,5,6}));
    }

    @Test
    @DisplayName("Sorted array in decrease")
    public void test3(){
        int[] dec = new int[] {10, 9, 8, 7, 6, 5, 4, 1};
        assertEquals(dec.length - 1, IncreaseSequence.getK(dec));
    }
}