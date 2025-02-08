package sortings;

import java.util.Arrays;

public class SortInAWaveForm {
    public static void sortInWaveForm(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n - 1; i = i + 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }

    }

    public static void sortInWaveFormOptimized(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i = i + 2) {
            if (i > 0 && arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

            if (i < n - 1 && arr[i] < arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        
    }
    public static void main(String[] args) {
        int[] arr = { 10, 90, 49, 2, 1, 5, 23 };

        // T.C - O(nlogn) + O(n) = O(nlogn)
        // S.C - O(1)
        // sortInWaveForm(arr);

        // T.C - O(n)
        // S.C - O(1)
        sortInWaveFormOptimized(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
