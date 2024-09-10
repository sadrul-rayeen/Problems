package MonotonicStack;

import java.util.Stack;

public class NextGreaterElement2 {
    public static int[] nextGreaterElement2BruteForce(int[] nums) {
        int n = nums.length;
        int N = 2 * n;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            boolean isAdded = true;
            for (int j = i + 1; j < i + N - 1; j++) {
                int index = j % n;

                if (nums[index] > nums[i]) {
                    res[i] = nums[index];
                    isAdded = false;
                    break;
                }
            }

            if (isAdded) {
                res[i] = -1;
            }
        }

        return res;
    }

    public static int[] nextGreaterElement2Optimal(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                res[i] = st.isEmpty() ? -1 : st.peek();
            }
            
            st.push(nums[i % n]);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = { 1,2,3,4,3 };

        // int[] result = nextGreaterElement2BruteForce(nums);
        int[] result = nextGreaterElement2Optimal(nums);

        for (int r : result) {
            System.out.println(r);
        }
    }
}
