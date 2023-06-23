class Solution {
    public int longestArithSeqLength(int[] nums) {

        int ans = 0;
        int n = nums.length;

        if(n<=2)return n;
        HashMap<Integer, Integer>[] dp = new HashMap[n+1];
        
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashMap<Integer,Integer>();
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int diff = nums[i]-nums[j];
                int cnt = 1;
                if(dp[j].containsKey(diff)){
                    cnt = dp[j].get(diff);
                }
                dp[i].put(diff,cnt+1);
                ans = Math.max(ans,dp[i].get(diff));
            }
        }
        return ans;
    }
}