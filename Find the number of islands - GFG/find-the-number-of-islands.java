//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public void dfs(int r,int c,int[][] visited,char[][] grid,int[] drow,int[] dcol){
         visited[r][c] = 1;
         for(int i=0;i<8;i++){
             int nrow = r + drow[i];
             int ncol = c + dcol[i];
             
             if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && visited[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                dfs(nrow,ncol,visited,grid,drow,dcol);
             }
         }
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        
        
        int[] drow = {-1,0,1,0,1,1,-1,-1};
        int[] dcol = {0,1,0,-1,1,-1,1,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,visited,grid,drow,dcol);
                }
            }
        }
        
        return cnt;
    }
}