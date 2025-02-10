package BinarySearch;

public class FindMaxInIncreasingAndDecreasingArray {
    public static int findMaxInIncAndDesArray(int[] arr) {
        int n = arr.length;

        if (n == 1 || arr[0] > arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] > arr[n - 2]) {
            return arr[n - 1];
        }

        int l = 1;
        int r = n - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = arr[mid];
            int midPrevValue = arr[mid - 1];
            int midNextValue = arr[mid + 1];
            if (midValue > midPrevValue && midValue > midNextValue) {
                return midValue;
            }
            if (midValue > midPrevValue && midValue < midNextValue) {
                l = mid + 1;
            } else if (midValue < midPrevValue && midValue > midNextValue) {
                r = mid - 1;
            }
        }
        return arr[r];
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 4, 5, 7, 8, 3 };

        int result = findMaxInIncAndDesArray(input);
        System.out.println("result " + result);

    }
}
