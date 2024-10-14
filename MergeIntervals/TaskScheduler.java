package MergeIntervals;

public class TaskScheduler {
    public static int taskScheduler(char[] tasks, int cooldown) {
        int[] taskCounts = new int[26];
        // Maximum frequency among the tasks
        int maxFrequency = 0;

        // Loop over the tasks to count them and find the task with maximum frequency.
        for (char task : tasks) {
            // Convert the task from char type to an index for our count array
            int index = task - 'A';
            // Increment the count for this task
            taskCounts[index]++;
            // Update the maximum frequency
            maxFrequency = Math.max(maxFrequency, taskCounts[index]);
        }

        // Count how many tasks have the maximum frequency
        int maxFrequencyTasks = 0;
        for (int count : taskCounts) {
            if (count == maxFrequency) {
                maxFrequencyTasks++;
            }
        }

        // Calculate the minimum length of the task schedule
        // Each block of tasks includes the cooldown period followed by the most frequent task itself
        // Then, add the number of tasks with maximum frequency to cover the last one without tailing idle time
        int minScheduleLength = Math.max(tasks.length, (maxFrequency - 1) * (cooldown + 1) + maxFrequencyTasks);

        return minScheduleLength;
    }
    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int cooldown = 2;

        int result = taskScheduler(tasks, cooldown);

        System.out.println(result);
    }
}
