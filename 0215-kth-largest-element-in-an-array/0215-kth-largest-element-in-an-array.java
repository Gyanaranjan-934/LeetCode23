class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums){
            if(pq.size()<=k)pq.add(i);
            while(pq.size()>k)pq.remove();
        }
        return pq.peek();
    }
}