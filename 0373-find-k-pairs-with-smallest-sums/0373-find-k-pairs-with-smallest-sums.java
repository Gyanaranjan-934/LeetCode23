import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[0]);
            pair.add(0);
            pq.offer(pair);
        }
        
        while (k-- > 0 && !pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            res.add(cur.subList(0, 2));
            
            int nextIndex = cur.get(2) + 1;
            if (nextIndex == nums2.length) {
                continue;
            }
            
            List<Integer> nextPair = new ArrayList<>();
            nextPair.add(cur.get(0));
            nextPair.add(nums2[nextIndex]);
            nextPair.add(nextIndex);
            pq.offer(nextPair);
        }
        
        return res;
    }
}
