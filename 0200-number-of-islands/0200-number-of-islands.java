class Solution {
    private void dfs(int row,int col,char[][] grid,boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;

        visited[row][col] = true;

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && grid[nrow][ncol]=='1' && !visited[nrow][ncol])
                dfs(nrow,ncol,grid,visited);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited =  new boolean[n][m];
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    cnt++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return cnt;
    }
}