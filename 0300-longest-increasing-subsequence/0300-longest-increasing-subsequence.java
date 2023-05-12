class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return recFunc(0,nums,-1,dp);
    }
    public int recFunc(int ind,int[] arr,int prev,int[][] dp){
        if(ind==arr.length){
            return 0 ;        
        }
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];
        int notPick = recFunc(ind+1,arr,prev,dp);
        int pick = 0;
        if(prev == -1 || arr[ind]>arr[prev]){
            pick = 1 + recFunc(ind+1,arr,ind,dp);
        }
        return dp[ind][prev+1] = Math.max(pick,notPick);
    }
}