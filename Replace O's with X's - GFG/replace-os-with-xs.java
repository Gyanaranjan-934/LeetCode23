//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair{
    int row;
    int col;
    Pair(int a,int b){
        this.row = a;
        this.col = b;
    }
}

class Solution{
    static char[][] fill(int n, int m, char arr[][])
    {
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(arr[i][0]=='O')q.add(new Pair(i,0));
            if(arr[i][m-1]=='O')q.add(new Pair(i,m-1));
        }
        for(int i=0;i<m;i++){
            if(arr[0][i]=='O')q.add(new Pair(0,i));
            if(arr[n-1][i]=='O')q.add(new Pair(n-1,i));
        }
        
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,1,0,-1};
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            arr[p.row][p.col] = 'M';
            for(int i=0;i<4;i++){
                int nrow = p.row+drow[i];
                int ncol = p.col+dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && arr[nrow][ncol]=='O')
                    q.add(new Pair(nrow,ncol));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='O')arr[i][j]='X';
                else if(arr[i][j]=='M')arr[i][j]='O';
            }
        }
        return arr;
    }
}