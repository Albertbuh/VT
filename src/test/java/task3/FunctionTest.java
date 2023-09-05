package task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    @Test
    @DisplayName("test for values: a = -2.7, b = 2.7, h = 0.3")
    public void test() {
        Function f = new Function();
        f.countValues(-2.7, 2.7, 0.3);
        f.printValues();
        assertTrue(true);
    }

    @Test
    @DisplayName("test for values: a = -4.7, b = 1.7, h = 0.33")
    public void test2() {
        Function f = new Function();
        f.countValues(-4.7, 1.7, 0.33);
        f.printValues();
        assertTrue(true);
    }

    @Test
    @DisplayName("test for values: a = -117, b = 123, h = 0.01")
    public void test3() {
        Function f = new Function();
        f.countValues(-117, 123, 0.01);
        f.printValues();
        assertTrue(true);
    }
}