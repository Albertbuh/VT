package task8;

public class SequenceInsert {
    private static final double eps = 0.000001;

    public static int[] getIndexes(double[] a, double[] b) {
        int indA = 0;
        int indB = 0;
        int lengthA = a.length;
        int lengthB = b.length;
        int[] result = new int[lengthB];
        int ind = 0;

        while(indB < lengthB && indA < lengthA) {
            boolean isFinded = false;
            while(indA < lengthA && !isFinded) {
                if(a[indA] <= b[indB]) {
                    indA++;
                } else {
                    result[ind++] = indA;
                    isFinded = true;
                }
            }
            indB++;
        }

        while(ind < lengthB) {
            result[ind++] = indA;
        }
        return result;
    }

    public static int[] getIndexesIncludeAddedBefore(double[] a, double[] b) {
        int indA = 0;
        int indB = 0;
        int lengthA = a.length;
        int lengthB = b.length;
        int[] result = new int[lengthB];
        int ind = 0;
        int addedAmount = 0;

        while(indB < lengthB && indA < lengthA) {
            boolean isFinded = false;
            while(indA < lengthA && !isFinded) {
                if(a[indA] <= b[indB]) {
                    indA++;
                } else {
                    result[ind++] = indA + addedAmount;
                    addedAmount++;
                    isFinded = true;
                }
            }
            indB++;
        }

        while(ind < lengthB) {
            result[ind++] = indA + addedAmount;
            addedAmount++;
        }
        return result;
    }

    protected static void printIndexes(int[] indexes) {
        for(var el: indexes) {
            System.out.format("%d ", el);
        }
        System.out.println();
    }
}
