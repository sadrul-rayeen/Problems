package TwoPointers;

public class SumOfSquareNumbers {
    public static boolean isSumOfSquareNumbers(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right) {
            long total = (left * left) + (right * right);

            if (total == c) {
                return true;
            }

            if (total < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int c = 2147483600;

        boolean result = isSumOfSquareNumbers(c);
        System.out.println(result);
    }
}
