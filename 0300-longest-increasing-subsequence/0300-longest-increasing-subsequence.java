class Solution {
    public int lengthOfLIS(int[] nums) {
        // 1. Recursion + Memoization
        // int n = nums.length;
        // int[][] dp = new int[n][n+1];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        // return recFunc(0,nums,-1,dp);

        // 2. Tabulation
        // int n = nums.length;
        // int[][] dp = new int[n+1][n+1];
        // for(int ind=n-1;ind>=0;ind--){
        //     for(int prev=ind-1;prev>=-1;prev--){
        //         int pick = 0;
        //         if(prev == -1 || nums[ind]>nums[prev]){
        //             pick = 1 + dp[ind+1][ind+1];
        //         }
        //         int notPick = dp[ind+1][prev+1];
        //         dp[ind][prev+1] = Math.max(pick,notPick);
        //     }
        // }
        // return dp[0][0];

        // Space Optimization
        int n = nums.length;
        int[] ahead = new int[n+1];
        int[] curr = new int[n+1];

        for(int ind = n-1;ind>=0;ind--){
            for(int prev=ind-1;prev>=-1;prev--){
                int pick = 0;
                if(prev==-1||nums[ind]>nums[prev]){
                    pick = 1 + ahead[ind+1];
                }
                int notPick = ahead[prev+1];
                curr[prev+1] = Math.max(pick,notPick);
            }
            ahead = curr;
        }
        return ahead[0];
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