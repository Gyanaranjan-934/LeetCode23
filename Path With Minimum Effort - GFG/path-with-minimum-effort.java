//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


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
    public int MinimumEffort(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] effort = new int[n][m];
        for(int[] row :effort)
            Arrays.fill(row,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        pq.add(new Pair(0,0,0));

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!pq.isEmpty()){
            int sDist = pq.peek().dist;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.remove();

            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newEffort = Math.max(sDist,Math.abs(grid[nrow][ncol]-grid[r][c]));
                    if(newEffort < effort[nrow][ncol]){
                        pq.add(new Pair(newEffort,nrow,ncol));
                        effort[nrow][ncol] = newEffort;
                    }
                }
                    
                
            }
        }
        return effort[n-1][m-1] == Integer.MAX_VALUE ? 0 : effort[n-1][m-1];
    }
}