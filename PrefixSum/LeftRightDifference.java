package PrefixSum;

public class LeftRightDifference {
    public static int[] leftRightDifferenceBruteForceOptimal(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;
        int[] result = new int[n];

        for (int num: nums) {
            rightSum += num;
        }

        for (int j = 0; j < n; j++) {
            rightSum -= nums[j];
            result[j] = Math.abs(leftSum - rightSum);
            leftSum += nums[j];
        }

        return result;
    }

    public static int[] leftRightDifferenceBruteForce(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] result = new int[n];
        leftSum[0] = 0;
        rightSum[n-1] = 0;

        for (int i = 0; i < n - 1; i++) {
            leftSum[i + 1] = nums[i] + leftSum[i];
        }

        for (int j = n - 1; j > 0; j--) {
            rightSum[j - 1] = nums[j] + rightSum[j];
        }

        for (int k = 0; k < n; k++) {
            result[k] = Math.abs(leftSum[k] - rightSum[k]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = { 10, 4, 8, 3 };

        // int[] result = leftRightDifferenceBruteForce(arr);
        int[] result = leftRightDifferenceBruteForceOptimal(arr);

        for (int res : result) {
            System.out.println(res + " ");
        }
    }
}
