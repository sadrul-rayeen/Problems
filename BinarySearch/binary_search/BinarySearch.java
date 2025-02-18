package BinarySearch.binary_search;

public class BinarySearch {
    public static int search(int[] nums, int target) {
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

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;

        int result = search(nums, target);
        System.out.println("result : " + result);
    }
}
