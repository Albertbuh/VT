package task6;

public class Matrix {
    private int[][] matrix;
    private int size;
    public Matrix(int[] array){
        size = array.length;
        matrix = new int[size][size];
        fillMatrix(array);
    }

    public int[][] get() {
        return matrix;
    }

    public void fillMatrix(int[] array) {
        int startInd;
        for(int i=0; i<size; i++) {
            startInd = i;
            for(int j=0; j<size; j++) {
                int ind = (startInd + j) % size;
                matrix[i][j] = array[ind];
            }
        }
    }

    public void print() {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                System.out.format("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
