package task9;

public class Ball {
    public double weight;
    public String color;
    public static final String defaultColor = "unknown";
    public Ball() {
        this.weight = 0;
        this.color = defaultColor;
    }

    public Ball(double weight) {
        this.weight = weight;
        this.color = "unknown";
    }

    public Ball(double weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}
