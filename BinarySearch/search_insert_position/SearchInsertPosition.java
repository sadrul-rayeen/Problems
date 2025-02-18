package BinarySearch.search_insert_position;

public class SearchInsertPosition {
    public static int findInsertPosition(int[] nums, int target) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] < target) {
                i++;
            } else if (nums[i] > target) {
                return i;
            }
        }

        return i;
    }

    public static int findInsertPositionUsingBS(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    public static void main(String[] args) {
        int[] input = { 1, 3, 5, 6 };
        int target = 5;

        // Brute force approach
        // T.C. - O(n)
        // int result = findInsertPosition(input, target);

        // optimal opproach using binary search
        // T.C. - O(logn)
        int result = findInsertPositionUsingBS(input, target);
        System.out.println("result " + result);
    }
}
