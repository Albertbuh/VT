package task2;

public class Shape {
    public static boolean isInnerPoint(double x, double y)  {
        return onTopOfFigure(x, y) || onBottomOfFigure(x,y);
    }
    protected static boolean onTopOfFigure(double x, double y) {
        return (y >= 0 && y <= 5) && (x >= -4 && x <= 4);
    }

    protected static boolean onBottomOfFigure(double x, double y) {
        return (y >= -3 && y < 0) && (x >= -6 && x <= 6);
    }
}
