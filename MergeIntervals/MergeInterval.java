package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static int[][] findNonOverlap(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        //Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                //overlapping the intervals
                //update the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                //Disjoint intervals
                // add new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 7, 10 }, { 15, 18 } };

        int[][] result = findNonOverlap(intervals);

        for (int[] firstLevel : result) {
            System.out.println("[" + firstLevel[0] + ", " + firstLevel[1] + "]");
        }
    }
}
