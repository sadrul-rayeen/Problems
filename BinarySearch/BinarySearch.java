package BinarySearch;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int l, int r, int target) {
        if (l <= r) {
            int mid = l + (r - l) / 2;

            if (target < arr[mid]) {
                return binarySearchRecursive(arr, l, mid - 1, target);
            } else if (target > arr[mid]) {
                return binarySearchRecursive(arr, mid + 1, r, target);
            } else {
                return mid;
            }
        }

        return -1;
        
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 5;

        // T.C - O(logn)
        // S.C - O(1)
        // int result = binarySearch(arr, target);

        // T.C - O(logn)
        // S.C - O(logn)
        int result = binarySearchRecursive(arr, 0, arr.length - 1, target);
        System.out.println(result);
    }
}
