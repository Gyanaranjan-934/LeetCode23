class Solution {
    public int recFunc(int i,int j,int m,int n,int[][] dp){
        if(i==0 && j==0)return 1;
        if(i<0 || i>=m || j<0 || j>=n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int up = recFunc(i-1,j,m,n,dp);
        int left = recFunc(i,j-1,m,n,dp);
        return dp[i][j] = up+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row:dp)Arrays.fill(row,-1);
        return recFunc(m-1,n-1,m,n,dp);
    }
}