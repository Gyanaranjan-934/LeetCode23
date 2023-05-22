class Pair{
    int val;
    int freq;
    Pair(int a,int b){
        this.val = a;
        this.freq = b;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->y.freq-x.freq);
        
        int elem = nums[0];
        int cnt = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==elem)cnt++;
            else{
                pq.add(new Pair(elem,cnt));
                elem = nums[i];
                cnt = 1;
            }
        }
        pq.add(new Pair(elem,cnt));
        
        int[] res = new int[k];
        for(int i=0;i<k;i++)
            res[i] = pq.poll().val;
        
        return res;
    }
}