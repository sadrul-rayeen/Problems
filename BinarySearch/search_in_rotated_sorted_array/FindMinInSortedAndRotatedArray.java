package BinarySearch.search_in_rotated_sorted_array;

public class FindMinInSortedAndRotatedArray {
    public static int findIndex(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (arr[l] < arr[r]) {
                return arr[l];
            }
            int mid = l + (r - l) / 2;

            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return arr[l];
    }

    public static void main(String[] args) {
        int[] input = { 11, 13, 15, 17 };
        int result = findIndex(input);
        System.out.println("result " + result);
    }
}
