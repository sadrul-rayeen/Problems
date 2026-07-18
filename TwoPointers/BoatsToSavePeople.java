package TwoPointers;

public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int boats = 0;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {
        int[] people = { 1, 2 };
        int limit = 3;

        int result = numRescueBoats(people, limit);
        System.out.println(result);
    }
}
