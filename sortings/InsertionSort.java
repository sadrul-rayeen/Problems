package sortings;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) { // 2
            int currValue = arr[i]; // 4
            int j = i - 1; // 1

            while (j >= 0 && arr[j] > currValue) { // 0 > 4
                arr[j + 1] = arr[j]; // 5
                j = j - 1; // 0
            }
            arr[j + 1] = currValue; // 4
        }

    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
