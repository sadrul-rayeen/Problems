package HashMap;

public class FirstUniqueCharacter {
    public static int findUniqueCharacter(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < s.length(); j++) {
            if (charCount[s.charAt(j) - 'a'] == 1) {
                return j;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        String s = "leetcode";

        int index = findUniqueCharacter(s);
        System.out.println(index);
    }
}
