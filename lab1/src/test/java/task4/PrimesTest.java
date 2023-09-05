package task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimesTest {

    @Test
    @DisplayName("Simple output: [1,2,3,4,5,6,7,8,9,10]")
    public void test() {
        int[] a = new int[10];
        for(int i=0; i<10; i++)
            a[i] = i;
        Primes.checkCollectionToPrimes(a);
        assertArrayEquals(new Object[] {2,3,5,7}, Primes.getPrimesList());
    }

    @Test
    @DisplayName("Test case: [763, 291, 13, 764, -3, 23, -119]")
    public void test2() {
        int[] a = new int[] {763, 291, 13, 764, -3, 23, -119};
        Primes.checkCollectionToPrimes(a);
        assertArrayEquals(new Object[] {2, 5}, Primes.getPrimesList());
    }
}