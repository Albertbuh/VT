package task6;

public class Matrix {
    private double[][] matrix;
    private int size;
    public Matrix(double[] array){
        size = array.length;
        matrix = new double[size][size];
        fillMatrix(array);
    }

    public double[][] get() {
        return matrix;
    }

    public void fillMatrix(double[] array) {
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
                System.out.format("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
