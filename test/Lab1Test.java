import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class Lab1Test {
    private static final double EPS = 1e-9;

    @Test
    public void firstFormulaWhenDIsEight() {
        assertEquals(Math.E, Lab1.calculateElement((short) 8, -1f), EPS);
    }

    @Test
    public void firstFormulaOverflowsForLargeX() {
        assertEquals(Double.POSITIVE_INFINITY, Lab1.calculateElement((short) 8, 15f));
    }

    @Test
    public void secondFormulaForAllDValuesFromSet() {
        double expected = Math.log(Math.pow(Math.pow(Math.tan(1), 2) / (2 / Math.PI + 1), 2));
        for (short d : new short[] {2, 6, 10, 14, 20}) {
            assertEquals(expected, Lab1.calculateElement(d, 1f), EPS);
        }
    }

    @Test
    public void secondFormulaIsMinusInfinityWhenXIsZero() {
        assertEquals(Double.NEGATIVE_INFINITY, Lab1.calculateElement((short) 2, 0f));
    }

    @Test
    public void thirdFormulaForOtherDValues() {
        double expected = Math.log((Math.PI / 2 + 1) / 2 * Math.PI);
        for (short d : new short[] {4, 12, 16, 18}) {
            assertEquals(expected, Lab1.calculateElement(d, -1.5f), EPS);
        }
    }

    @Test
    public void printMatrixUsesThreeDecimalPlaces() {
        Locale.setDefault(Locale.US);
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        try {
            Lab1.printMatrix(new double[][] {{1.23456, -2}, {0, 10.5}});
        } finally {
            System.setOut(originalOut);
        }
        String separator = System.lineSeparator();
        String expected = "       1.235      -2.000" + separator + "       0.000      10.500" + separator;
        assertEquals(expected, output.toString());
    }
}
