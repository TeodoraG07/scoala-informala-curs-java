import calculatorapplication.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorApplicationTest {
    //happy flow test
    @ParameterizedTest
    @ValueSource(strings = {
            "10 cm + 1 m - 10 mm",
            "10 cm + 1 km - 10 m",
            "10 dm + 1 km - 10 m",
            "10 m + 1 km - 10 m",
            "10 km + 1 km - 10 km",
            "10 cm"
    })
    void testCalculatorLowestMetric(String expression) {

        Calculator calculator = new Calculator();
        int result = calculator.processCalculation(expression);

        int expected = expectedResult(expression);

        assertEquals(expected, result);
    }

    private int expectedResult(String expr) {
        switch (expr) {
            case "10 cm + 1 m - 10 mm":
                return 1090;
            case "10 cm + 1 km - 10 m":
                return 99010;
            case "10 dm + 1 km - 10 m":
                return 9910;
            case "10 m + 1 km - 10 m":
                return 1000;
            case "10 km + 1 km - 10 km":
                return 1;
            case "10 cm":
                return 10;

        }

        return 0;


    }

    //unhappy flow - invalid metric
    @Test
    void testCalculatorWrongMetric() {

        Calculator calculator = new Calculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.processCalculation("45 yz + 78 cm");
        });
    }

    //unhappy flow - null expression
    @Test
    void testCalculatorNullExpression() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.processCalculation("");
        });
    }

    //unhappy flow - unexpected operator
    @Test
    void TestCalculatorUnexpectedOperator() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.processCalculation("10 cm * 34 km");
        });
    }

    //unhappy flow - no spaces btw the inputs
    @Test
    void TestCalculatorNoSpaces() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.processCalculation("10cm+34km");
        });
    }
}



