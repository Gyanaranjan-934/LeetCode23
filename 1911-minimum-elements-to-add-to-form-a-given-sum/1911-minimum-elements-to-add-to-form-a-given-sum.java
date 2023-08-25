class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(int i : nums)sum+=(long)i;
        if(sum==goal)return 0;
        long req = Math.abs(goal-sum);
        if(req<=(long)limit)return 1;
        long cnt = 0;
        cnt += (req/limit);
        if(req%limit!=0)cnt++;
        return (int)cnt;
    }
}