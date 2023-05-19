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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int dist;
    int row;
    int col;
    Pair(int a,int b,int c){
        this.dist = a;
        this.row = b;
        this.col = c;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] distance = new int[n][m];
        for(int[] row :distance)
            Arrays.fill(row,Integer.MAX_VALUE);
            
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        
        pq.add(new Pair(0,source[0],source[1]));
        
        distance[source[0]][source[1]]=0;
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        
        while(pq.size()!=0){
            int sDist = pq.peek().dist;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.remove();
            
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && sDist+1 < distance[nrow][ncol]){
                    pq.add(new Pair(sDist+1,nrow,ncol));
                    distance[nrow][ncol] = sDist+1;
                }
                
            }
            
        }
        
        return distance[destination[0]][destination[1]] != Integer.MAX_VALUE ? distance[destination[0]][destination[1]] : -1;
        
    }
}
