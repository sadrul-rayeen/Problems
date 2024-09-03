package SeptemberMonth.Easy;

public class SumOfDigitAfterConvert {
    public static int getLucky(String s, int k) {
        String convertedString = "";

        for (char c : s.toCharArray()) {
            convertedString += c - 'a' + 1;
        }

        int result = 0;

        while (k > 0) {
            int total = 0;

            for (char c : convertedString.toCharArray()) {
                int value = c - '0';
                total += value;
            }
            result = total;
            k--;
            convertedString = "" + total;
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "zbax";
        int k = 2;

        int result = getLucky(s, k);
        System.out.println(result);
    }
}
