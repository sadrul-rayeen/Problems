package sortings;

public class CountingSort {
    public static int[] countingSort(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];

        // find max element in the array
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // create a count array of size max+1
        int[] count = new int[max + 1];
        for (int j = 0; j < n; j++) {
            count[arr[j]]++;
        }

        // calculate the prefix sum
        for (int k = 1; k <= max; k++) {
            count[k] += count[k - 1];
        }

        // build the output array
        for (int l = n - 1; l >= 0; l--) {
            output[count[arr[l]] - 1] = arr[l];
            count[arr[l]]--;
        }

        return output;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2, 7, 5, 2};
        int[] sortedArr = countingSort(arr);
        for (int i : sortedArr) {
            System.out.print(i + " ");
        }
    }
}
