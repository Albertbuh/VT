package task9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    @Test
    @DisplayName("Weight")
    public void testWeight() {
        Ball[] balls = new Ball[] {
                new Ball(1.2, "red"),
                new Ball(2, "blue"),
                new Ball(4),
                new Ball(0.3, "red"),
                new Ball(3.13, "red")
        };
        double expected = 0;
        for(var ball:balls) {
            expected += ball.weight;
        }
        expected /= balls.length;

        Basket b = new Basket(balls);
        assertEquals(expected, b.GetBallsWeight());
    }

    @Test
    @DisplayName("Color")
    public void testColor() {
        Ball[] balls = new Ball[] {
                new Ball(1.2, "red"),
                new Ball(2, "blue"),
                new Ball(4),
                new Ball(0.3, "red"),
                new Ball(3.13, "red")
        };
        Basket b = new Basket(balls);
        assertEquals(3, b.GetBallsAmountByColor("red"));
    }

    @Test
    @DisplayName("Color unknown")
    public void testColorUnknown() {
        Ball[] balls = new Ball[] {
                new Ball(1.2, "red"),
                new Ball(2, "blue"),
                new Ball(4),
                new Ball(0.3, "red"),
                new Ball(3.13, "red")
        };
        Basket b = new Basket(balls);
        assertEquals(1, b.GetBallsAmountByColor());
    }
}