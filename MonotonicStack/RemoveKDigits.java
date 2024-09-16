package MonotonicStack;

public class RemoveKDigits {
    public static String removeKDigits(String num, int k) {
        int n = num.length();
        if (n == k) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (!sb.isEmpty() && c < sb.charAt(sb.length() - 1) && k != 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return "0";
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public static void main(String[] args) {
        String num = "112";
        int k = 1;

        String result = removeKDigits(num, k);
        System.out.println(result);
    }
}
