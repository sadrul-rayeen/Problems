package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacter {
    // Time - O(n) + O(log(256))
    // Space - O(256)
    public static int findLongestMostOptimal(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (right < n) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            if (map.size() <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            if (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);

                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }

                left++;
            }

            right++;
        }

        return maxLength;
    }
    // Time - O(n) + O(n) + O(log(256))
    // Space - O(256)
    public static int findLongestOptimal(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (right < n) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            if (map.size() <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);

                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }

                left++;
            }

            right++;
        }

        return maxLength;
    }
    // Time - O(n * n) + O(log(256))
    // space - O(256)
    public static int findLongestBruteForce(String s, int k) {
        int maxLength = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.clear();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                if (map.size() <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        String s = "WORLD";
        int k = 4;

        // int len = findLongestBruteForce(s, k);
        // int len = findLongestOptimal(s, k);
        int len = findLongestMostOptimal(s, k);
        System.out.println(len);
    }
}
