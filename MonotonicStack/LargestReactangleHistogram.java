package MonotonicStack;

public class LargestReactangleHistogram {
    public static int findLargestRectangle(int[] heights) {
        int n = heights.length;
        int maxRectangleArea = heights[0];

        for (int i = 0; i < n - 1; i++) {
            int mini = heights[i];
            for (int j = i + 1; j < n; j++) {
                int innerSum = 0;
                if (mini == 0) {
                    mini = heights[j];
                    innerSum = (mini * (j - i));
                } else {
                    mini = Math.min(mini, heights[j]);
                    innerSum = (mini * (j - i + 1));
                }
                
                
                maxRectangleArea = Math.max(maxRectangleArea, innerSum);

            }

        }

        return maxRectangleArea;
    }
    public static void main(String[] args) {
        int[] heights = { 2,1,5,6,2,3 };
        
        int result = findLargestRectangle(heights);
        System.out.println(result);
    }
}
