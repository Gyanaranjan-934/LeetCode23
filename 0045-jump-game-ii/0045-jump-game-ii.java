class Solution {
    private int recFunc(int ind,int[] arr,int[] dp){
        if(ind>=arr.length-1)return 0;
        if(dp[ind]!=-1)return dp[ind];
        int res = (int)1e7;
        for(int i=1;i<=arr[ind];i++){
            int temp = 1+recFunc(ind+i,arr,dp);
            res = Math.min(res,temp);
        }
        return dp[ind] = res;
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        // Arrays.fill(dp,-1);
        // return recFunc(0,nums,dp);

        for(int ind=nums.length-2;ind>=0;ind--){
            int res = (int)1e7;
            for(int i=1;i<=nums[ind];i++){
                if(ind+i<=nums.length-1){
                    int temp = 1+recFunc(ind+i,nums,dp);
                    res = Math.min(res,temp);
                }
            }
            dp[ind] = res;
        }
        return dp[0];
    }
}