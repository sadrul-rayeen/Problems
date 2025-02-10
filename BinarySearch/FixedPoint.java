package BinarySearch;

public class FixedPoint {
    public static int findFixedPoint(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == i) {
                return i;
            }
        }

        return -1;
    }

    public static int findFixedPointUsingBinarySearch(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = arr[mid];

            if (midValue == mid) {
                return mid;
            }

            if (midValue < mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static int findFixedPointWithDuplicatesUsingBinarySearch(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = arr[mid];

            if (midValue == mid) {
                return mid;
            }

            int leftIndex = Math.min(mid - 1, midValue);

            if (leftIndex >= l && arr[leftIndex] == leftIndex) {
                return leftIndex;
            }

            if (midValue > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] input = { -4, -2, 0, 1, 4, 6, 7 };

        // brute force approach
        // T.C - O(n)
        // S.C - O(1)
        // int result = findFixedPoint(input);

        // using binary search
        // T.C - O(logn)
        // S.C - O(1)
        int result = findFixedPointUsingBinarySearch(input);

        // int result = findFixedPointWithDuplicatesUsingBinarySearch(input);
        System.out.println("result " + result);
    }
}