class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : hand) {
            pq.add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        while (pq.size() >= groupSize) {
            int a = pq.poll();
            System.out.print(a+" ");
            int k = groupSize - 1;
            
            while (!pq.isEmpty() && k > 0) {
                if (pq.peek() == a) {
                    q.add(pq.poll());
                } else if (pq.peek() == a + 1) {
                    a = pq.poll();
                    // System.out.print(a+" ");
                    k--;
                } else {
                    return false;
                }
            }
            // System.out.println();
            if (k > 0 && pq.isEmpty()) {
                return false;
            }
            
            while (!q.isEmpty()) {
                pq.add(q.poll());
            }
        }
        
        return pq.isEmpty();
    }
}
