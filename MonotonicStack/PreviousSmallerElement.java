package MonotonicStack;

import java.util.Stack;

public class PreviousSmallerElement {
    public static int[] previousSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
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
        int[] arr = { 5, 7, 9, 6, 7, 4 };

        // int[] result = nextGreaterElement1BruteForce(arr);
        int[] result = previousSmallerElement(arr);


        for (int r : result) {
            System.out.println(r);
        }
    }
}
