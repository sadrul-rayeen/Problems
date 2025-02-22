package BinarySearch.find_peak_element;

public class FindPeakElement {
    public static int findPeak(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 5, 6, 5 };

        int result = findPeak(nums);
        System.out.println("result : " + result);
    }
}
