package SlidingWindow;

import java.util.Arrays;

/**
 * PermutationInString
 * 
 * Problem - Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

        In other words, return true if one of s1's permutations is the substring of s2.

        Example 1:

            Input: s1 = "ab", s2 = "eidbaooo"
            Output: true
            Explanation: s2 contains one permutation of s1 ("ba").

        Example 2:

            Input: s1 = "ab", s2 = "eidboaoo"
            Output: false
 

        Constraints:

            1 <= s1.length, s2.length <= 104
            s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString {
    //we can use solve this problem using sliding window 
    // time - O(alphabet_size * len(s2))
    public static boolean findPermutationInString(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) {
            return false;
        }

        int[] s1hash = new int[26];
        int[] s2hash = new int[26];
        int left = 0;
        int right = 0;

        while (right < s1Len) {
            s1hash[s1.charAt(right) - 'a']++;
            s2hash[s2.charAt(right) - 'a']++;
            right++;
        }
        right--;

        while (right < s2Len) {
            if (Arrays.equals(s1hash, s2hash)) {
                return true;
            }
            right++;
            if (right != s2Len) {
                s2hash[s2.charAt(right) - 'a']++;
            }
            s2hash[s2.charAt(left) - 'a']--;
            left++;
        }

        return false;

    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = findPermutationInString(s1, s2);

        System.out.println(result);
    }
}