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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] mat)
    {
        // Code here
        Queue<int[]> q = new LinkedList<>();
        int row = mat.length;
        int col = mat[0].length;
        int fresh = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==2)q.add(new int[]{i,j});
                if(mat[i][j]!=0)fresh++;
            }
        }
        
        int time = 0;
        int rotten = q.size();
        if(q.isEmpty() || fresh==q.size())return time;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] arr = q.remove();
                int k = arr[0];
                int l = arr[1];
                if(k>0 && mat[k-1][l]==1){
                    mat[k-1][l]=2;
                    q.add(new int[]{k-1,l});
                    rotten++;
                }
                if(l>0 && mat[k][l-1]==1){
                    mat[k][l-1]=2;
                    q.add(new int[]{k,l-1});
                    rotten++;
                }
                if(k<row-1 && mat[k+1][l]==1){
                    mat[k+1][l]=2;
                    q.add(new int[]{k+1,l});
                    rotten++;
                }
                if(l<col-1 && mat[k][l+1]==1){
                    mat[k][l+1]=2;
                    q.add(new int[]{k,l+1});
                    rotten++;
                }
            }
            
            if(q.size()!=0)time++;
        
        }
        return rotten==fresh?time:-1;
    }
}