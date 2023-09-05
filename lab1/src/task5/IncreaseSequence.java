package task5;

public class IncreaseSequence {
    public static int getK(int[] sequence) {
        int length = sequence.length;
        int[] subsequence = new int[length];
        subsequence[0] = sequence[0];
        for(int i=1; i<length; i++)
            subsequence[i] = Integer.MAX_VALUE;
        int lastInd = 0;

        for(int i=1; i<length; i++) {
            if(sequence[i] > subsequence[lastInd]) {
                lastInd++;
                subsequence[lastInd] = sequence[i];
            }
            else {
                int ind = binarySearch(subsequence, sequence[i]);
                subsequence[ind] = sequence[i];
            }
        }
        int subsequenceLength = lastInd + 1;

        return length - subsequenceLength;
    }

    private static int binarySearch(int[] array, int x) {
        int l = 0;
        int r = array.length - 1;
        int m = 0;

        while (l <= r) {
            m = (l + r) / 2;
            if (array[m] >= x)
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }
}
