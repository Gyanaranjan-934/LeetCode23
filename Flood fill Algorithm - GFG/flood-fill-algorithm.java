//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;

        int iniCol = image[sr][sc];
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, +1, 0, -1}; 
        dfs(sr,sc,ans,image,iniCol,color,drow,dcol);
        return ans;

    }
    private void dfs(int r,int c,int[][] ans,int[][] image,int iniCol,int newCol,int[] drow,int[] dcol){
        
        ans[r][c]=newCol;
        for(int i=0;i<4;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow >=0 && nrow <ans.length && ncol>=0 && ncol<ans[0].length && image[nrow][ncol]==iniCol && ans[nrow][ncol]!=newCol){
                
                dfs(nrow,ncol,ans,image,iniCol,newCol,drow,dcol);
            }

        }
    }
}