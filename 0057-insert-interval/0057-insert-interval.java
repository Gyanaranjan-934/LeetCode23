import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;

        // Add intervals before newInterval that end before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // Merge intervals that overlap with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // Add the merged newInterval
        mergedIntervals.add(newInterval);

        // Add remaining intervals
        while (i < intervals.length) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // Convert mergedIntervals list to a 2D array and return
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
