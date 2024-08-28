package PrefixSum;

import java.util.HashMap;

public class NumSubarraysWithSum {
    public static int numSubarraysWithSumOptimal2(int[] nums, int goal) {
        if (goal < 0)
            return 0;

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (right < nums.length) {
            sum = sum + nums[right];

            while (sum > goal) {
                sum = sum - nums[left];
                left++;
            }
            count = count + (right - left + 1);

            right++;
        }
        return count;
    }

    public static int numSubarraysWithSumOptimal(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum = preSum + nums[i];
            int remove = preSum - k;
            count = count + map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
    
    public static int numSubarraysWithSum(int[] arr, int goal) {
        int n = arr.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = i; j < n; j++) {
                total = total + arr[j];
                if (total == goal) {
                    maxLength++;
                }
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 0, 1 };
        int goal = 2;

        // int result = numSubarraysWithSum(arr, goal);
        // int result = numSubarraysWithSumOptimal(arr, goal);
        int result = numSubarraysWithSumOptimal2(arr, goal);
        int result2 = numSubarraysWithSumOptimal2(arr, goal - 1);
        System.out.println(result - result2);
    }
}
