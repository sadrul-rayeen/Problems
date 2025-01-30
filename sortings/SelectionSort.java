package sortings;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = { 5, 3, 4, 2, 1 };
        selectionSort(arr);
        for (int i = 0; i < arr.length; i = i + 1) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
