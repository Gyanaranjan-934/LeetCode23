class Solution {
    private int recFunc(int ind,int[] arr,int[] dp){
        if(ind<0) return 0;
        if(dp[ind]!=-1)return dp[ind];
        return dp[ind] = Math.max(arr[ind]+recFunc(ind-2,arr,dp),recFunc(ind-1,arr,dp));
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return recFunc(nums.length-1,nums,dp);
    }
}