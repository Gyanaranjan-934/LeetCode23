class Solution {
    public int recFunc(int start,int end,int[] arr,int[][] dp){
        if(start==end)return arr[start];
        if(dp[start][end]!=-1)return dp[start][end];
        int pickRight=arr[end]-recFunc(start,end-1,arr,dp);
        int pickLeft=arr[start]-recFunc(start+1,end,arr,dp);
        return dp[start][end] = Math.max(pickLeft,pickRight);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int[] row:dp)Arrays.fill(row,-1);
        int res = recFunc(0,piles.length-1,piles,dp);
        if(res<0)return false;
        return true;
    }
}