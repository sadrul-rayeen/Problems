package sortings;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped = false;
        for (int i = 0; i < n; i = i + 1) {
            for (int j = 0; j < n - i - 1; j = j + 1) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 4, 2, 1 };
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i = i + 1) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
