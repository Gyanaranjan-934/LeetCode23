class Solution {
    private boolean recFunc(int ind,int[] nums,int[] dp){
        int n = nums.length;
        if(ind==n)return true;
        if(dp[ind]!=-1)return dp[ind]==1?true:false;
        if(ind+1<n){
            if(nums[ind]==nums[ind+1]){
                if(recFunc(ind+2,nums,dp)){
                    dp[ind] = 1;
                    return true;
                }

                if(ind+2<n && nums[ind]==nums[ind+2])
                    if(recFunc(ind+3,nums,dp)){
                        dp[ind] = 1;
                        return true;
                    }
            }
        }
        if(ind+2<n && nums[ind+1]==nums[ind]+1 && nums[ind+2]==nums[ind]+2){
            if(recFunc(ind+3,nums,dp)){
                dp[ind] = 1;
                return true;
            }
        }
        dp[ind]=0;
        return false;
    }
    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return recFunc(0,nums,dp);
    }
}