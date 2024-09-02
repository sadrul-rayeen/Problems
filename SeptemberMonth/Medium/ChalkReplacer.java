package SeptemberMonth.Medium;

public class ChalkReplacer {
    public static int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += chalk[i];

            if (sum > k) {
                break;
            }
        }

        k = k % (int) sum;

        for (int j = 0; j < n; j++) {
            if (k < chalk[j]) {
                return j;            
            }
            k = k - chalk[j];
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] chalk = { 3,4,1,2 };
        int k = 25;

        int result = chalkReplacer(chalk, k);
        System.out.println(result);
    }
}
