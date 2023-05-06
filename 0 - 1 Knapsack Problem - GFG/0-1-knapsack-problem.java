//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    {
        // 1. Recursion + Memoization
        // int[][] dp = new int[n][w+1];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        // return recFunc(n-1,w,wt,val,dp);
        
        // 2. Tabulation
        int[][] dp = new int[n][w+1];
        
        
        
        for(int i=wt[0];i<=w;i++)
            dp[0][i] = val[0];
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=w;j++){
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=j)
                    pick = val[i]+dp[i-1][j-wt[i]];
                    
                dp[i][j] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][w];
           
    }
    
    static int recFunc(int ind,int w,int[] wt,int[] val,int[][] dp){
        if(ind<=0){
            return wt[ind]<=w ? val[ind] : 0;
        }
        
        if(dp[ind][w]!=-1)return dp[ind][w];
        
        int notPick = recFunc(ind-1,w,wt,val,dp);
        int pick = Integer.MIN_VALUE;
        if(wt[ind]<=w)
            pick = val[ind]+recFunc(ind-1,w-wt[ind],wt,val,dp);
        
        return dp[ind][w] = Math.max(pick,notPick);
        
    }
}


