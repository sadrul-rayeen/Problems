package MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int n2 = nums2.length;

        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = n2 - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                m.put(nums2[i], -1);
            } else {
                m.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = m.get(nums1[i]);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        int[] result = nextGreaterElement1(nums1, nums2);

        for (int r : result) {
            System.out.println(r);
        }
    }
}