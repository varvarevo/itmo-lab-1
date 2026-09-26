import java.util.Arrays;

public class Lab1 {
    public static void main(String[] args) {
        short[] d = new short[10];
        for (int i = 0; i < d.length; i++) {
            d[i] = (short) (2 + 2 * i);
        }

        System.out.println("1. Array d (short, even numbers from 2 to 20):");
        System.out.println(Arrays.toString(d));
        System.out.println();

        float[] x = new float[15];
        for (int i = 0; i < x.length; i++) {
            x[i] = (float) (Math.random() * 27.0 - 12.0);
        }

        System.out.println("2. Array x (float, 15 random numbers from -12.0 to 15.0):");
        System.out.println(Arrays.toString(x));
        System.out.println();

        double[][] n = new double[10][15];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                n[i][j] = calculateElement(d[i], x[j]);
            }
        }

        System.out.println("3-4. Array n (10x15), rows by d[i], columns by x[j]:");
        printMatrix(d, x, n);
    }

    public static double calculateElement(short d, float x) {
        switch (d) {
            case 8:
                return Math.exp(Math.exp(Math.pow(0.25 * (x + 1), 3)));
            case 2:
            case 6:
            case 10:
            case 14:
            case 20:
                return Math.log(Math.pow(Math.pow(Math.tan(x), 2) / ((Math.abs(x) + 1) / Math.PI + 1), 2));
            default:
                return Math.log((Math.PI / 2 + Math.abs(Math.cos(Math.asin((x + 1.5) / 27)))) / 2 * Math.PI);
        }
    }

    public static void printMatrix(short[] d, float[] x, double[][] matrix) {
        System.out.print("  d \\ x |");
        for (float value : x) {
            System.out.printf(" %8.3f", value);
        }
        System.out.println();

        System.out.print("--------+");
        for (int j = 0; j < x.length; j++) {
            System.out.print("---------");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%7d |", d[i]);
            for (double value : matrix[i]) {
                System.out.printf(" %8.3f", value);
            }
            System.out.println();
        }
    }
}
