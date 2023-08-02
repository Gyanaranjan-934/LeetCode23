//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Tuple{
    int row;
    int col;
    int dist;
    Tuple(int a,int b,int c){
        this.row = a;
        this.col = b;
        this.dist = c;
    }
}

class Solution {
    boolean isValid(int n,int m,int nrow,int ncol,int[][] arr){
        if(nrow<0 || nrow>=n || ncol<0 || ncol>=m || arr[nrow][ncol]==0)return false;
        return true;
    }
    int shortestDistance(int n, int m, int arr[][], int x, int y) {
        if(arr[0][0]==0)return -1;
        int[][] dist = new int[n][m];
        for(int[] row : dist)Arrays.fill(row,10000);
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,0));
        dist[0][0] = 0;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            
            for(int i=0;i<4;i++){
                int nrow = drow[i]+t.row;
                int ncol = dcol[i]+t.col;
                
                if(isValid(n,m,nrow,ncol,arr) && dist[nrow][ncol]>dist[t.row][t.col]+1){
                    q.add(new Tuple(nrow,ncol,dist[t.row][t.col]+1));
                    dist[nrow][ncol] = dist[t.row][t.col]+1;
                }
            }
            
        }
        if(dist[x][y]<10000)return dist[x][y];
        return -1;
    }
};