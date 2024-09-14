package MonotonicStack;

import java.util.ArrayList;
import java.util.List;

public class AestroidCollision {
    public static int[] removeCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0) {
                result.add(asteroids[i]);
            } else {
                while (!result.isEmpty() && result.getLast() > 0 && result.getLast() < Math.abs(asteroids[i])) {
                    result.removeLast();
                }
                if (!result.isEmpty() && result.getLast() == Math.abs(asteroids[i])) {
                    result.removeLast();
                } else if (result.isEmpty() || result.getLast() < 0) {
                    result.add(asteroids[i]);
                }
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public static void main(String[] args) {
        int[] asteroids = { 5,10,-5 };
        
        int[] result = removeCollision(asteroids);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
