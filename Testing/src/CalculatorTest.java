import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    @DisplayName("Calculator's Add Function")
    void add() {
        assertEquals(4, Calculator.add(2, 2));
    }

    @Test
    void addMany() {
        assertEquals(15, Calculator.add(getManyNumbers(5)));
    }

    @Test
    @DisplayName("Calculator's Multiply Function")
    void multiply() {
        assertAll(() -> assertEquals(120, Calculator.multiply(getManyNumbers(5))),
                () -> assertEquals(2, Calculator.multiply(2, 1)));

    }

    double[] getManyNumbers(int n) {
        double[] myNumbers = new double[n];
        for(int i = 0; i < n; i++) {
            myNumbers[i] = i + 1; // 1,2,3,4,5
        }
        return myNumbers;
    }
}