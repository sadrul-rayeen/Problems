package Searching;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Return the index of the target element
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Return -1 if the target element is not found
    }

    public static int binarySearchUsingRecursion(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: target not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Return the index of the target element
        } else if (arr[mid] < target) {
            return binarySearchUsingRecursion(arr, target, mid + 1, right); // Search in the right half
        } else {
            return binarySearchUsingRecursion(arr, target, left, mid - 1); // Search in the left half
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 8 }; // The array must be sorted for binary search
        int target = 10;
        // int result = binarySearch(arr, target);
        int result = binarySearchUsingRecursion(arr, target, 0, arr.length - 1);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
