package task8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceInsertTest {

    @Test
    @DisplayName("Setting indexes according to elements added before")
    public void testWithInclude() {
        double[] a = new double[] {1, 3, 5, 7, 9};
        double[] b = new double[] {2, 4, 6, 8, 10};
        int[] result = SequenceInsert.getIndexesIncludeAddedBefore(a, b);
        SequenceInsert.printIndexes(result);
        assertArrayEquals(new int[] {1,3,5,7,9}, result);
    }

    @Test
    public void test() {
        double[] a = new double[] {1, 3, 5, 7, 9};
        double[] b = new double[] {2, 4, 6, 8, 10};
        int[] result = SequenceInsert.getIndexes(a, b);
        SequenceInsert.printIndexes(result);
        assertArrayEquals(new int[] {1,2,3,4,5}, result);
    }
}