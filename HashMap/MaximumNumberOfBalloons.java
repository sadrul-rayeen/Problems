package HashMap;

public class MaximumNumberOfBalloons {
    public static int findNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }

        count['l' - 'a'] >>= 1;
        count['o' - 'a'] >>= 1;

        int result = Integer.MAX_VALUE;

        for (char s: "balon".toCharArray()) {
            result = Math.min(result, count[s - 'a']);
        }

        return result;
    }
    public static void main(String[] args) {
        String text = "nlaebolko";

        int result = findNumberOfBalloons(text);
        System.out.println(result);
    }
}
