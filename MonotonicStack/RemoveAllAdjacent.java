package MonotonicStack;

import java.util.HashMap;
import java.util.Map;

public class RemoveAllAdjacent {
    public static String removeAllAdjacentMethod1(String s, int k) {
        HashMap<Character, Integer> m = new HashMap<>();

        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> r : m.entrySet()) {
            if (r.getValue() != k) {
                for (int i = 0; i < r.getValue() % k; i++) {
                    sb.append(r.getKey());
                }
            }
        }

        return sb.toString();
    }

    public static String removeAllAdjacentMethod2(String s, int k) {
        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);
            int last = sb.length() - 1;
            count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last - 1) ? count[last - 1] : 0);
            if (count[last] >= k) {
                sb.delete(sb.length() - k, sb.length());
            }
        }
        
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;

        // String result = removeAllAdjacentMethod1(s, k);
        String result = removeAllAdjacentMethod2(s, k);
        System.out.println(result);
    }
}
