package BinarySearch;

public class RowWithMaxOne {
    public static int findMaxOne(int[][] input) {
        int row = input.length;
        int col = input[0].length;

        int rowMaxOnes = 0;
        int maxRowIndex = -1;

        for (int i = 0; i < row; i++) {
            int maxOnes = 0;
            for (int j = 0; j < col; j++) {
                if (input[i][j] == 1) {
                    maxOnes++;
                }

                if (rowMaxOnes < maxOnes) {
                    rowMaxOnes = maxOnes;
                    maxRowIndex = i;
                }
            }
        }

        return maxRowIndex;
    }

    public static int searchFirstIndex(int[] row, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;

            if ((row[mid - 1] == 0 || mid == 0) && row[mid] == 1) {
                return mid;
            } else if (row[mid] == 0) {
                return searchFirstIndex(row, mid + 1, r);
            } else {
                return searchFirstIndex(row, l, mid - 1);
            }
        }

        return -1;
    }

    public static int findMaxOneUsingBinarySearch(int[][] input) {
        int row = input.length;
        int col = input[0].length;

        int maxOneCount = 0;
        int maxRowIndex = -1;

        for (int i = 0; i < row; i++) {
            int firstOneIndex = searchFirstIndex(input[i], 0, col - 1);
            int rowOneCount = col - firstOneIndex;

            if (maxOneCount != -1 && rowOneCount > maxOneCount) {
                maxOneCount = rowOneCount;
                maxRowIndex = i;
            }
        }

        return maxRowIndex;
    }

    public static int findMaxOneFromTopRight(int[][] input) {
        int row = input.length;
        int col = input[0].length;

        int maxOneIndex = -1;
        int currCol = col - 1;
        for (int i = 0; i < row; i++) {
            while (currCol >= 0 && input[i][currCol] == 1) {
                currCol--;
                maxOneIndex = i;
            }
        }

        return maxOneIndex;
    }

    public static void main(String[] args) {
        int[][] input = { { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 0, 0, 0 } };

        // T.C - O(n*m)
        // int result = findMaxOne(input);

        // T.C - O(n*log(m))
        // int result = findMaxOneUsingBinarySearch(input);

        int result = findMaxOneFromTopRight(input);
        System.out.println("result : " + result);
    }
}
