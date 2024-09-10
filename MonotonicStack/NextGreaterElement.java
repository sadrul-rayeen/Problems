package MonotonicStack;

import java.util.Stack;

public class NextGreaterElement {
    // TC - O(n ** 2)
    // SC - O(1)
    public static int[] nextGreaterElement1BruteForce(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            boolean isAdded = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    isAdded = false;
                    break;
                }
            }
            if (isAdded) {
                result[i] = -1;

            }
        }

        return result;
    }
    
    // TC - O(2 * n)
    // SC - O(n) + O(n)
    public static int[] nextGreaterElement1Optimal(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = { 6, 0, 8, 1, 3 };

        // int[] result = nextGreaterElement1BruteForce(arr);
        int[] result = nextGreaterElement1Optimal(arr);


        for (int r : result) {
            System.out.println(r);
        }
    }
}
