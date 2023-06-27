class Tuple{
    int val;
    int rInd;
    int cInd;
    Tuple(int a,int b,int c){
        this.val = a;
        this.rInd = b;
        this.cInd = c;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->x.val-y.val);
        
        for(int i=0;i<m;i++){
            pq.add(new Tuple(nums1[i]+nums2[0],i,0));
        }
        while(!pq.isEmpty() && res.size()<k){
            Tuple t = pq.poll();
            int rInd = t.rInd;
            int cInd = t.cInd;
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[rInd]);
            temp.add(nums2[cInd]);
            res.add(temp);
            if(cInd<n-1){
                pq.add(new Tuple(nums1[rInd]+nums2[cInd+1],rInd,cInd+1));
            }
        }
        return res;
    }
}