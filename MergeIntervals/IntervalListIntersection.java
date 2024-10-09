package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public static int[][] intersectionList(int[][] a, int[][] b) {
        System.out.println(a.length);
        System.out.println(b.length);

        List<int[]> result = new ArrayList<>();

        int aPointer = 0;
        int bPointer = 0;
        int sizeA = a.length;
        int sizeB = b.length;

        

        while (aPointer < sizeA && bPointer < sizeB) {
            if (b[bPointer][0] <= a[aPointer][1] && a[aPointer][0] <= b[bPointer][1]) {
                int[] temp = new int[2];

                temp[0] = Math.max(a[aPointer][0], b[bPointer][0]);
                temp[1] = Math.min(a[aPointer][1], b[bPointer][1]);
                
                result.add(temp);

                System.out.println(temp[0] + " " + temp[1]);
            }

            if (a[aPointer][1] > b[bPointer][1]) {
                bPointer++;
            } else {
                aPointer++;
            }
        }

        return result.toArray(new int[result.size()][]);

    }
    public static void main(String[] args) {
        int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

        int[][] result = intersectionList(firstList, secondList);

        for (int[] firstLevel : result) {
            System.out.println("[" + firstLevel[0] + ", " + firstLevel[1] + "]");
        }
    }
}
