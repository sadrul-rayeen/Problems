package MergeIntervals;

import java.util.Arrays;

public class NonOverlapping {
    public static int numberOfNonOverlapping(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int size = intervals.length;
        int result = 0;
        int currentEnd = intervals[0][1];
        for (int i = 1; i < size; i++) {
            if (intervals[i][0] >= currentEnd) {
                currentEnd = intervals[i][1];
            } else {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } };

        int result = numberOfNonOverlapping(intervals);

        System.out.println(result);
    }
}

