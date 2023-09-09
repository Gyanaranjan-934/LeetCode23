class Solution {
    private int recFunc(int[] arr,int tar,int[] dp){
        if(tar==0)return 1;
        if(tar<0)return 0;
        if(dp[tar]!=-1)return dp[tar];
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans += recFunc(arr,tar-arr[i],dp);
        }
        return dp[tar] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return recFunc(nums,target,dp);
    }
}