class Pair{
    int first;
    int second;
    Pair(int a,int b){
        this.first = a;
        this.second = b;
    }
}
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Pair(nums2[i],nums1[i]));
        }
        Collections.sort(list,(x,y)->y.first-x.first);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long curr = 0;
        long best = 0;
        for(int i=0;i<n;i++){
            pq.add(list.get(i).second);
            curr += list.get(i).second;
            if(pq.size()>k){
                int mini = pq.peek();
                pq.remove();
                curr -= mini;
            }
            if(pq.size()==k)
                best = Math.max(best,curr*list.get(i).first);
        }
        return best;
    }
}