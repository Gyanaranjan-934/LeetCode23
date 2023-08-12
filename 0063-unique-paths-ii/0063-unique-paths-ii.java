class Solution {
    private int recFunc(int srow,int scol,int[][] grid,int[][] dp){
        int m = grid.length;
        int n = grid[0].length;
        if(srow==m-1 && scol==n-1)return 1;
        if(dp[srow][scol]!=-1)return dp[srow][scol];
        int res = 0;
        if(srow+1<m && grid[srow+1][scol]==0)
            res += recFunc(srow+1,scol,grid,dp);
        if(scol+1<n && grid[srow][scol+1]==0)
            res += recFunc(srow,scol+1,grid,dp);

        return dp[srow][scol] = res;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1]; 
        for(int[] row : dp)Arrays.fill(row,-1);
        return recFunc(0,0,obstacleGrid,dp);
    }
}