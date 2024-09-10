package MonotonicStack;

public class NextGreaterElement1 {
    public static int[] nextGreaterElement1BruteForce(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            boolean isAdded = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    isAdded = false;
                    break;
                }
            }
            if (isAdded) {
                result[i] = -1;

            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr = { 6, 0, 8, 1, 3 };

        int[] result = nextGreaterElement1BruteForce(arr);

        for (int r : result) {
            System.out.println(r);
        }
    }
}
