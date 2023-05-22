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
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->y.freq-x.freq);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++)
            res[i] = pq.poll().val;
        
        return res;
    }
}