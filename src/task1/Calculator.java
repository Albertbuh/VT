package task1;

public class Calculator {
    public static double solve(double x, double y) {
        return countNumerator(x, y) / countDenominator(x, y) + x;
    }

    private static double countNumerator(double x, double y) {
        return 1 + Math.sin(x+y)*Math.sin(x+y);
    }

    private static double countDenominator(double x, double y) {
        return 2 + Math.abs(x - (2 * x) / (1 + x*x * y*y));
    }
}
