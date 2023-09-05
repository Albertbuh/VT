import task9.Ball;
import task9.Basket;

public class Main {
    public static void main(String[] args) {
        Ball[] balls = new Ball[] {
                new Ball(3.4, "red"),
                new Ball(5, "white"),
                new Ball(12, "blue"),
                new Ball(3, "red"),
                new Ball(12, "white"),
        };
        Basket basket = new Basket(balls);
        System.out.format("Amount of white balls: %d\n", basket.getBallsAmountByColor("white"));
        System.out.format("Total weight of balls: %.2f g", basket.getBallsWeight());
    }
}