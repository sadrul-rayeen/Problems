package MonotonicStack;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public static int findSumRangesBruteForce(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int mini = nums[i];
            int maxi = nums[i];

            for (int j = i; j < n; j++) {
                mini = Math.min(mini, nums[j]);
                maxi = Math.max(maxi, nums[j]);

                sum = sum + (maxi - mini);
            }

        }

        return sum;
    }

    public static int[] findNge(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            if (st.empty()) {
                result[i] = n;
            } else {
                result[i] = st.peek();
            }

            st.push(i);
        }

        return result;
    }
    public static int[] findNse(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                result[i] = n;
            } else {
                result[i] = st.peek();
            }

            st.push(i);
        }

        return result;
    }

    public static int[] findPse(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
    
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }

            st.push(i);
        }

        return result;
    }
    public static int[] findPge(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }

            st.push(i);
        }

        return result;
    }

    public static int findSumRangesOptimal(int[] arr) {
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);
        int[] nge = findNge(arr);
        int[] pge = findPge(arr);

        int totalMin = 0;
        int totalMax = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            totalMin = totalMin + (right * left * arr[i]);
        }

        for (int j = 0; j < arr.length; j++) {
            int left = j - pge[j];
            int right = nge[j] - j;

            totalMax = totalMax + (right * left * arr[j]);
        }

        return totalMax - totalMin;
    }
    public static void main(String[] args) {
        int[] nums = { 4,-2,-3,4,1 };

        // int result = findSumRangesBruteForce(nums);
        int result = findSumRangesOptimal(nums);
        System.out.println(result);
    }
}
