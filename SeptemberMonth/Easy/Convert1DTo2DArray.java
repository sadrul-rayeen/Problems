package SeptemberMonth.Easy;

public class Convert1DTo2DArray {
    public static int[][] convert1DTo2D(int[] original, int m, int n) {
        int size = original.length;

        if (m * n != size) {
            return new int[0][0];
        }

        int result[][] = new int[m][n];
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index];
                index++;
            }
        }

        return result;
    }
    public static int[][] convert1DTo2DOptimal(int[] original, int m, int n) {
        int size = original.length;

        if (m * n != size) {
            return new int[0][0];
        }

        int result[][] = new int[m][n];

        for (int i = 0; i < size; i++) {
            result[i / n][i % n] = original[i];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int m = 2;
        int n = 2;

        // convert1DTo2D(arr, m, n);
        convert1DTo2DOptimal(arr, m, n);

    }
}
