package task4;

import java.util.ArrayList;

public class Primes {

    private static ArrayList<Integer> primes = new ArrayList<Integer>(); //store indexes of prime elements, not prime elements directly
    public static void checkCollectionToPrimes(int[] arr) {
        primes.clear();
        int length = arr.length;
        System.out.println("Indexes: ");
        for(int i=0; i<length; i++) {
            if(isPrime(arr[i])) {
                primes.add(i);
                System.out.format("%d ", i);
            }
        }
        System.out.println();
    }

    protected static void setPrimesList(int[] values) {
        if(primes == null)
            primes = new ArrayList<Integer>();

        primes.clear();
        for(var a: values)
            primes.add(a);
    }
    public static Integer[] getPrimesList() {
        if(primes == null)
            throw new NullPointerException("primes is not initialized");

        return primes.toArray(new Integer[0]);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;

        if (n % 2 == 0) return false;

        double lim = Math.sqrt(n) + 1;
        for (int i = 3; i <= lim; i += 2){
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
