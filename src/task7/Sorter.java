package task7;

public class Sorter {
    public static double[] Sort(double[] a) {
        int length = a.length;
        int ind = 0;
        while(ind < length - 1) {
            if(a[ind] <= a[ind+1]) {
                ind++;
            }
            else {
                swap(a, ind, ind+1);
                if(ind >= 1)
                    ind--;
            }
        }
        print(a);
        return a;
    }

    public static void print(double[] a){
        for(var elem: a) {
            System.out.println(elem);
        }
    }
    protected static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
