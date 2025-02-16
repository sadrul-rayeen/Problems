package BinarySearch;

public class MedianOfTwoSortedArrays {
    public static double findMedian(int[] a, int[] b) {
        int n = a.length;
        int[] margedArray = new int[2 * n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < n) {
            if (a[i] <= b[j]) {
                margedArray[k] = a[i];
                i++;
            } else {
                margedArray[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            margedArray[k] = a[i];
            i++;
            k++;
        }

        while (j < n) {
            margedArray[k] = b[j];
            j++;
            k++;
        }

        return (double) (margedArray[n - 1] + margedArray[n]) / 2;
    }

    public static double findMedianUsingCounting(int[] a, int[] b) {
        int n = 2 * a.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int middle1 = 0;
        int middle2 = 0;

        while (count <= n) {
            if (a[i] <= b[j]) {
                middle1 = middle2;
                middle2 = a[i];
                i++;
            } else {
                middle1 = middle2;
                middle2 = b[j];
                j++;
            }

            if (i == n) {
                middle1 = middle2;
                middle2 = b[0];
                break;
            }

            else if (j == n) {
                middle1 = middle2;
                middle2 = a[0];
                break;
            }

            count++;
        }

        return (double) (middle1 + middle2) / 2;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 6 };
        int[] b = { 2, 8, 12 };

        // brute force using extra space
        // T.C - O(n)
        // S.C - O(n)
        // double result = findMedian(a, b);

        // optimize approach using counting while merging
        double result = findMedianUsingCounting(a, b);

        System.out.println("result : " + result);
    }
}
