package MonotonicStack;

import java.util.Stack;

public class DailyTemp {
    public static int[] findDailyTempBruteForce(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = 0; i < n - 1; i++) {
            boolean isFind = false;
            for (int j = i + 1; j < n; j++) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    isFind = true;
                    break;
                }
            }

            if (!isFind) {
                result[i] = 0;
            }
        }

        return result;
    }

    public static int[] findDailyTempBruteOptimal(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                result[i] = st.peek() - i;
            }

            st.push(i);
        }
        

        return result;
    }
    public static void main(String[] args) {
        int[] temperatures = { 30,40,50,60 };

        // int[] result = findDailyTempBruteForce(temperatures);
        int[] result = findDailyTempBruteOptimal(temperatures);

        for (int r : result) {
            System.out.println(r);
        }
    }
}
