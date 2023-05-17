//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int row;
    int col;
    Pair(int _row,int _col){
        this.row = _row;
        this.col = _col;
    }
}

class Solution {

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    ArrayList<Integer> list = new ArrayList<>();
                    dfs(i,j,list,visited,grid,drow,dcol,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    private void dfs(int r,int c,ArrayList<Integer> list,int[][] visited,int[][] grid,int[] drow,int[] dcol,int srow,int scol){
        visited[r][c] = 1;
        list.add(r-srow);
        list.add(c-scol);
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<4;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,list,visited,grid,drow,dcol,srow,scol);
            }
        }
    }
}














