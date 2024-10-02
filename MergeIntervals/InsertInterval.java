package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        int[][] expandedIntervals = new int[intervals.length + 1][2];

        for (int i = 0; i < intervals.length; i++) {
            expandedIntervals[i] = intervals[i];
        }

        expandedIntervals[intervals.length] = newInterval;

        Arrays.sort(expandedIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] firstInterval = expandedIntervals[0];
        result.add(firstInterval);

        for (int[] interval : expandedIntervals) {
            if (interval[0] <= firstInterval[1]) {
                firstInterval[1] = Math.max(interval[1], firstInterval[1]);
            } else {
                firstInterval = interval;
                result.add(firstInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = { {1,5} };
        int[] newInterval = { 6, 8 };

        int[][] result = insertInterval(intervals, newInterval);

        for (int[] firstLevel : result) {
            System.out.println("[" + firstLevel[0] + ", " + firstLevel[1] + "]");
        }
    }
}
