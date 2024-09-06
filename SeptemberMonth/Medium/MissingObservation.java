package SeptemberMonth.Medium;

import java.util.Arrays;

public class MissingObservation {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum = sum + roll;
        }
        // Find the remaining sum.
        int remainingSum = mean * (n + rolls.length) - sum;
        // Check if sum is valid or not.
        if (remainingSum > 6 * n || remainingSum < n) {
            return new int[0];
        }
        int distributeMean = remainingSum / n;
        int mod = remainingSum % n;
        // Distribute the remaining mod elements in nElements array.
        int[] nElements = new int[n];
        Arrays.fill(nElements, distributeMean);
        for (int i = 0; i < mod; i++) {
            nElements[i]++;
        }
        return nElements;
    }
    public static void main(String[] args) {
        int[] rolls = { 3, 2, 4, 3 };
        int mean = 4;
        int n = 2;

        int[] result = missingRolls(rolls, mean, n);

        for (int r : result) {
            System.out.println(r);
        }
    }
}
