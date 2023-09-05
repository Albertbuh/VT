package task3;

import java.util.ArrayList;

//idk how to name this class :\
public class Function {
    private ArrayList<Point> data;

    private double eps = 0.000001;

    public Function() {}

    public Function(double eps) {
        this.eps = eps;
    }

    public ArrayList<Point> countValues(double a, double b, double h) {
        double x = a;
        ArrayList<Point> result = new ArrayList<Point>();
        result.add(new Point(x, func(x)));

        while(b - x >= eps) {
            x += h;
            result.add(new Point(x, func(x)));
        }

        fillData(result);

        return result;
    }

    private void fillData(ArrayList<Point> newData) {
        if(data == null)
            data = new ArrayList<Point>();

        data.clear();
        data = newData;
    }

    public void printValues() {
        if(data != null) {
            for (var point : data) {
                double x = point.x;
                double fx = point.funcX;
                if(Math.abs(x) < eps) //added just for correct output on screen, user no need to see -0.00
                    x = Math.abs(x);
                if(Math.abs(fx) < eps)
                    fx = Math.abs(fx);

                System.out.format("| %.6f | %.6f |\n", x, fx);
            }
        }
    }

    public double func(double x) {
        return Math.tan(x);
    }
}
