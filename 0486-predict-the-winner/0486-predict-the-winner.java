class Solution {
    private int recFunc(int l,int h,int[] nums,int[][] dp){
        if(l>h)return 0;
        if(l==h)return nums[l];
        if(dp[l][h]!=-1)return dp[l][h];
        int pickL = nums[l] - recFunc(l+1,h,nums,dp);
        int pickR = nums[h] - recFunc(l,h-1,nums,dp);

        return dp[l][h] = Math.max(pickL,pickR);

    }
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] row : dp)Arrays.fill(row,-1);
        int res = recFunc(0,nums.length-1,nums,dp);
        return res>=0;
    }
}