package SlidingWindow;

public class SubArrayProductLessThanK {
    public static int findProductBruteForce(int[] num, int k) {
        if (k <= 1)
            return 0;
        int maxProduct = 0;

        for (int i = 0; i < num.length; i++) {
            int product = 1;
            for (int j = i; j < num.length; j++) {
                product = product * num[j];
                if (product < k) {
                    maxProduct++;
                } else {
                    break;
                }
            }
        }

        return maxProduct;
    }

    public static int findProductOptimal(int[] nums, int k) {
        if (k <= 1) return 0;
        int productCount = 0;
        int n = nums.length;
        int product = 1;
        int left = 0;
        int right = 0;

        while (right < n) {
            product = product * nums[right];

            while (product >= k) {
                product = product / nums[left];
                left++;
            }

            productCount = productCount + (right - left + 1);
            right++;
        }

        return productCount;
    }
    public static void main(String[] args) {
        int[] num = { 1,2,3 };
        int k = 0;

        // int result = findProductBruteForce(num, k);
        int result = findProductOptimal(num, k);

        System.out.println(result);
    }
}
