package BinarySearch.sqrt;

public class Sqrt {
    public static int getSqrt(int input) {
        if (input == 0 || input == 1) {
            return input;
        }

        int left = 1;
        int right = input;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == input) {
                return mid;
            } else if ((long) mid * mid > (long) input) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return Math.round(right);
    }

    public static void main(String[] args) {
        int input = 2147395599;

        int result = getSqrt(input);
        System.out.println("result : " + result);
    }
}
