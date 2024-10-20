package PrefixSum;

public class MiddleIndexInArray {
    public static int findMiddleIndex(int[] arr) {
        int n = arr.length;
        int leftSum = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += arr[i];
        }

        for (int j = 0; j < arr.length; j++) {
            int rightSum = total - leftSum - arr[j];

            if (leftSum == rightSum) {
                return j;
            }

            leftSum += arr[j];
        }

        return -1;

    }
    public static void main(String[] args) {
        int[] arr = { 2, 3, -1, 8, 4, 10 };

        int result = findMiddleIndex(arr);

        System.out.println(result);
    }
}
