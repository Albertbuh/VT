package task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final double delta = 0.000001;
    @Test
    @DisplayName("Formula solution for values: x = 0, y = 0")
    void calculate1() {
        assertEquals(0.5, Calculator.solve(0,0), delta);
    }

    @Test
    @DisplayName("Formula solution for values: x = 3, y = 5")
    void calculate2() {
        assertEquals(3.3978785776481693, Calculator.solve(3,5), delta);
    }

    @Test
    @DisplayName("Formula solution for values: x = 0, y = 3pi/2")
    void calculate3() {
        assertEquals(1, Calculator.solve(0,3*Math.PI/2), delta);
    }

    @Test
    @DisplayName("Formula solution for values: x = -100, y = 3pi/2")
    void calculate4() {
        assertEquals(-99.98290579183296, Calculator.solve(-100,3*Math.PI/2), delta);
    }
}