//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] mat)
    {
        int n = mat.length;
        int m = mat[0].length;
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0)continue;
                int zeros =0;
                // up
                if(i-1>=0 && mat[i-1][j]==0)zeros++;
                // left
                if(j-1>=0 && mat[i][j-1]==0)zeros++;
                // down
                if(i+1<n && mat[i+1][j]==0)zeros++;
                // right
                if(j+1<m && mat[i][j+1]==0)zeros++;
                // top-left
                if(i-1>=0 && j-1>=0 && mat[i-1][j-1]==0)zeros++;
                // top-right
                if(i-1>=0 && j+1<m && mat[i-1][j+1]==0)zeros++;
                // bottom-left
                if(i+1<n && j-1>=0 && mat[i+1][j-1]==0)zeros++;
                // bottom-right
                if(i+1<n && j+1<m && mat[i+1][j+1]==0)zeros++;
                
                if(zeros>0 && zeros%2==0)cnt++;
            }
        }
        return cnt;
    }
}