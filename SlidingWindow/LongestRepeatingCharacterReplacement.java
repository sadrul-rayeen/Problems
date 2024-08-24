package SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static int findLongestRepeatingOptimal(String s, int k) {
        int arr[] = new int[26];
        int maxLength = 0;
        int maxFreq = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            arr[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, arr[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxFreq > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    // Time - O(n * n)
    // space - O(26)
    public static int findLongestRepeatingBruteForce(String s, int k) {
        int n = s.length();
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int maxFreq = 0;
            map.clear();

            for (int j = i; j < n; j++) {

                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(s.charAt(j)));

                int changes = (j - i + 1) - maxFreq;

                if (changes <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }

            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        // int len = findLongestRepeatingBruteForce(s, k);
        int len = findLongestRepeatingOptimal(s, k);

        System.out.println(len);
    }
}
