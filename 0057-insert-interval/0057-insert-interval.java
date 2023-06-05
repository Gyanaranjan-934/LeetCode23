import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<int[]> merge(List<int[]> list) {
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : list) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] row : intervals) {
            list.add(row);
        }

        if (list.isEmpty() || list.get(list.size() - 1)[1] < newInterval[0]) {
            list.add(newInterval);
        } else {
            addInterval(newInterval, list);
        }

        List<int[]> mergedIntervals = merge(list);

        int[][] res = new int[mergedIntervals.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = mergedIntervals.get(i);
        }

        return res;
    }

    private void addInterval(int[] newInterval, List<int[]> list) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid)[0] == newInterval[0]) {
                list.add(mid, newInterval);
                return;
            } else if (list.get(mid)[0] < newInterval[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        list.add(low, newInterval);
    }
}
