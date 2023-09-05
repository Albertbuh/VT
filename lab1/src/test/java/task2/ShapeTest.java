package task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {
    @Test
    @DisplayName("Upper part of figure: x = 2 y = 2")
    public void upper() {
        assertTrue(Shape.isInnerPoint(2, 2));
    }

    @Test
    @DisplayName("bottom part of figure: x = -6 y = -2.3")
    public void bottom() {
        assertTrue(Shape.isInnerPoint(-6, -2.3));
    }

    @Test
    @DisplayName("upper part zero y: x = 3, y = 0")
    public void upperZeroY() {
        assertTrue(Shape.isInnerPoint(2.93, 0));
    }

    @Test
    @DisplayName("bottom part zero y: x = 5, y = 0")
    public void bottomZeroY() {
        assertFalse(Shape.isInnerPoint(5.2, 0));
    }

    @Test
    @DisplayName("figure with crit values: x = ,5.99 y = -3")
    public void mantis() {
        assertTrue(Shape.isInnerPoint(5.99, -3));
    }

    @Test
    @DisplayName("figure with crit values: x = ,5.99 y = -3.000000001")
    public void mantis2() {
        assertFalse(Shape.isInnerPoint(5.99, -3.000000001));
    }

}