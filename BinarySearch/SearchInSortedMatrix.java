package BinarySearch;

public class SearchInSortedMatrix {
    public static boolean searchInRows(int[] rows, int columnLength, int k) {
        int l = 0;
        int r = columnLength - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (k == rows[mid]) {
                return true;
            }
            if (k < rows[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

    public static boolean findKInMatrix(int[][] mat, int k) {
        int rows = mat.length;
        int columns = mat[0].length;
        System.out.println("rows : " + rows + " columns " + columns);

        int l = 0;
        int r = rows - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (k >= mat[mid][0] && k <= mat[mid][columns - 1]) {
                return searchInRows(mat[mid], columns, k);
            }

            if (k < mat[mid][0]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] twoDInput = { { 1, 2, 6, 7 }, { 12, 13, 16, 21 }, { 23, 35, 36, 48 } };
        int k = 40;

        boolean result = findKInMatrix(twoDInput, k);
        System.out.println("result : " + result);
    }
}
