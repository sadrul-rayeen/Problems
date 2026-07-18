package TwoPointers.two_sum;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[] result = new int[2];
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int total = nums[left] + nums[right];

            if (total == target) {
                result[0] = left;
                result[1] = right;
                break;
            }
            if (total < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        // if array is sorted
        int[] result = twoSum(nums, target);

        // if array is not sorted
        // int[] result = twoSum1(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

}
