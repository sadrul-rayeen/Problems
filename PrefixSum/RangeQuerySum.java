package PrefixSum;

public class RangeQuerySum {
    public static int querySum(int[] arr, int left, int right) {
        int n = arr.length;
        int result = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        if (left > 0) {
            result = arr[right] - arr[left - 1];
        } else {
            result = arr[right];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = { -2, 0, 3, -5, 2, -1 };
        int left = 0;
        int right = 5;

        int result = querySum(arr, left, right);

        System.out.println(result);
    }
}
