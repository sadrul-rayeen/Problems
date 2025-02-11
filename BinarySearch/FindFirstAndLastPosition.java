package BinarySearch;

public class FindFirstAndLastPosition {
    public static int findFirstPosition(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if ((mid == 0 || arr[mid - 1] < target) && arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;

    }

    public static int findLastPosition(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if ((mid == n - 1 || arr[mid + 1] > target) && arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static int[] findFirstAndLastPosition(int[] arr, int target) {
        if (arr.length == 0) {
            int[] output = new int[2];
            output[0] = -1;
            output[1] = -1;
            return output;
        }
        int[] output = new int[2];
        output[0] = findFirstPosition(arr, target);
        output[1] = findLastPosition(arr, target);
        return output;
    }

    public static void main(String[] args) {
        int[] input = {};
        int target = 6;
        int[] result = findFirstAndLastPosition(input, target);
        System.out.println("First " + result[0] + " Second " + result[1]);
    }
}
