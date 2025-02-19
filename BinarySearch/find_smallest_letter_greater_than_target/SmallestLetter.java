package BinarySearch.find_smallest_letter_greater_than_target;

public class SmallestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int i = 0;

        while (i < n) {
            if ((letters[i] == target) || ((int) letters[i] < (int) target)) {
                i++;
            } else if ((int) letters[i] > (int) target) {
                return letters[i];
            }
        }
        return letters[0];
    }

    public static char nextGreatestLetterUsingBS(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int r = n - 1;
        int mid = l + (r - l) / 2;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target < letters[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return letters[l % n];
    }

    public static void main(String[] args) {
        char[] letters = { 'e', 'e', 'g', 'g' };
        char target = 'g';

        // T.C. - O(n)
        // char result = nextGreatestLetter(letters, target);

        char result = nextGreatestLetterUsingBS(letters, target);

        System.out.println("result " + result);
    }
}
