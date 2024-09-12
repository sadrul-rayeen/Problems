package MonotonicStack;

import java.util.Stack;

public class SumOfSubarrayMinimum {
    public static int sumOfSubarrayMinimumBruteForce(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int mini = arr[i];
            for (int j = i; j < n; j++) {
                mini = Math.min(mini, arr[j]);

                sum = sum + mini;
            }
        }

        return sum;
    }

    public static int[] findNSE(int[] arr) {
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

    public static int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
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

    public static int sumOfSubarrayMinimumOptimal(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = total + (right * left * arr[i]);
        }

        return total;
    }
    public static void main(String[] args) {
        int[] arr = { 11,81,94,43,3 };

        // int result = sumOfSubarrayMinimumBruteForce(arr);
        int result = sumOfSubarrayMinimumOptimal(arr);
        System.out.println(result);
    }
}
