package HashMap;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static int findLongest(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        boolean hasOdd = false;

        for (int freq: map.values()) {
            if (freq % 2 == 0) {
                res += freq;
            } else {
                res += freq - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) return res + 1;

        return res;
    }
    public static void main(String[] args) {
        String s = "abccccddd";

        int result = findLongest(s);
        System.out.println(result);
    }
}
