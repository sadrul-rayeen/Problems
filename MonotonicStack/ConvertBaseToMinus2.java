package MonotonicStack;

public class ConvertBaseToMinus2 {
    public static String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        int signAlteration = 1;

        while (n != 0) {
            if (n % 2 != 0) {
                result.append(1);
                n -= signAlteration;
            } else {
                result.append(0);
            }

            signAlteration *= -1;

            n = n / 2;
        }

        return result.reverse().toString();
    }
    public static void main(String[] args) {
        int n = 3;

        String result = baseNeg2(n);
        System.out.println(result);
    }
}
