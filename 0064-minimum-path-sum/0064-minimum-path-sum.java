class Solution {
    public int minPathSum(int[][] grid) {
//         ..................Recursion and Memoization...............
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return func(m-1,n-1,grid,dp);
    }
    
    public int func(int m,int n,int[][] grid,int[][] dp){
        if(m==0 && n==0){
            return grid[m][n];
        }
        
        if(m<0 || n<0)return (int)Math.pow(10,9);
        
        if(dp[m][n]!=-1)return dp[m][n];
        
        int up = grid[m][n] + func(m-1,n,grid,dp);
        int left = grid[m][n] + func(m,n-1,grid,dp);
        return dp[m][n] = Math.min(up,left);
        
}
}
// class Solution {
//     public int minPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         int dp[][]=new int[n][m];
    
//     for(int i=0; i<n ; i++){
//         for(int j=0; j<m; j++){
//             if(i==0 && j==0) dp[i][j] = matrix[i][j];
//             else{
                
//                 int up = matrix[i][j];
//                 if(i>0) up += dp[i-1][j];
//                 else up += (int)Math.pow(10,9);
                
//                 int left = matrix[i][j];
//                 if(j>0) left+=dp[i][j-1];
//                 else left += (int)Math.pow(10,9);
                
//                 dp[i][j] = Math.min(up,left);
//             }
//         }
//     }
    
//     return dp[n-1][m-1];
//     }
// }