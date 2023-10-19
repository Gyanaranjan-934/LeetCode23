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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Tuple{
    int row;
    int col;
    int dist;
    Tuple(int a ,int b, int c){
        this.row = a;
        this.col = b;
        this.dist = c;
    }
}
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        Queue<Tuple> q = new LinkedList<>();
        int dr = TargetPos[0]-1;
        int dc = TargetPos[1]-1;
        q.add(new Tuple(KnightPos[0]-1,KnightPos[1]-1,0));
        int res = Integer.MAX_VALUE;
        int[] drow = {-2,-2,-1,-1,1,1,2,2};
        int[] dcol = {-1,1,-2,2,-2,2,-1,1};
        int[][] vis = new int[n][n];
        vis[KnightPos[0]-1][KnightPos[1]-1] = 1;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            if(t.row==dr && t.col==dc){
                res = Math.min(res,t.dist);
            }
            for(int i=0;i<8;i++){
                int nrow = t.row+drow[i];
                int ncol = t.col+dcol[i];
                if(nrow >=0 && nrow < n && ncol>=0 && ncol<n && vis[nrow][ncol]==0){
                    vis[nrow][ncol] = 1;
                    q.add(new Tuple(nrow,ncol,t.dist+1));
                }
            }
        }
        return res;
    }
}