package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacter {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        int n = s.length();

        // Map to store the frequency of each character in the current window
        HashMap<Character, Integer> m = new HashMap<>();
        int i = 0; // left pointer for the sliding window
        int j = 0; // right pointer for the sliding window
        int result = Integer.MIN_VALUE; // variable to store the length of the longest substring

        // Iterate through the string using the right pointer of the sliding window
        while (j < n) {
            // Step 1: Update the count of the current character
            char c = s.charAt(j);
            int charFrequency = m.getOrDefault(c, 0);
            m.put(c, charFrequency + 1);
            
            // Step 2: Check map size is equal to given k value then calculate the answer 
            if (m.size() == k) {
                result = Math.max(result, j - i + 1);
            }
            // Step 3: Shrink the window from the left if count map has more than 'k' distinct characters 
            if (m.size() > k) {
                while (m.size() > k) {
                    char ithCharacter = s.charAt(i);
                    int ithValue = m.get(ithCharacter);
                    m.put(ithCharacter, ithValue - 1);

                    if (m.get(ithCharacter) == 0) {
                        m.remove(ithCharacter);
                    }
                    i++;
                }
            }
            j++;
        }

        System.out.println(result);
    }
}
