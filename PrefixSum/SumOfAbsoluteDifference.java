package PrefixSum;

public class SumOfAbsoluteDifference {
    public static int[] findAbsolute(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int total = 0;

            for (int j = 0; j < n; j++) {
                total = total + Math.abs(nums[i] - nums[j]);
            }

            result[i] = total;
        }

        return result;
    }

    public static int[] findAbsoluteOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = total + nums[i];
        }
        int prefix = 0;

        for (int i = 0; i < n; i++) {
            int difference = nums[i] * i - prefix + total - prefix - nums[i] * (n - i);
            result[i] = difference;
            prefix = prefix + nums[i];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = { 1,4,6,8,10 };

        // int[] result = findAbsolute(nums);
        int[] result = findAbsoluteOptimal(nums);
        for (int res : result) {
            System.out.println(res); 
        }
    }
}
