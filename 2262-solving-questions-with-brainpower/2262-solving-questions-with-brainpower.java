class Solution {
    public long mostPoints(int[][] mat) {
        int n = mat.length;
        // long[] dp = new long[n+mat[n-1][1]];
        // for(int i=0;i<dp.length;i++){
        //     dp[i] = -1;
        // }
        // return recFunc(0,mat,dp);

        long[] dp = new long[n+mat[n-1][1]+1];
        for(int i=n-1;i>=0;i--){
            int pickInd = Math.min(n,i+mat[i][1]+1);
            long pick = mat[i][0]+dp[pickInd];
            long notPick = dp[i+1];
            dp[i] = Math.max(pick,notPick);
        }

        return dp[0];
    }
    public long recFunc(int ind,int[][] mat,long[] dp){
        if(ind>=mat.length)return 0;
        if(dp[ind]!=-1)return dp[ind];
        long pick = mat[ind][0]+recFunc(ind+mat[ind][1]+1,mat,dp);
        long notPick = recFunc(ind+1,mat,dp);

        return dp[ind] = Math.max(pick,notPick);

    }
}