package PrefixSum;

import java.util.HashMap;

public class SubarraySumWithK {
    public static int subarraySumWithK(int[] nums, int k) {
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
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int k = 3;

        int result = subarraySumWithK(arr, k);

        System.out.println(result);
    }
}
