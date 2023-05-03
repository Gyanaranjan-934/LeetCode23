//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        // 1. Recursion
        // return recFunc(a-1,b-1);
        
        // 2. Memoization
        // int[][] dp = new int[a][b];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        // return memFunc(a-1,b-1,dp);
        
        // 3. Tabulation
        // int[][] dp = new int[a][b];
        // for(int i=0;i<a;i++){
        //     dp[i][0] = 1;
        // }
        // for(int i=0;i<b;i++){
        //     dp[0][i] = 1;
        // }
        
        
        // for(int i=1;i<a;i++){
        //     for(int j=1;j<b;j++){
        //         dp[i][j] = dp[i-1][j]+dp[i][j-1];
        //     }
        // }
        // return dp[a-1][b-1];
        
        // 4. Space Optimization
        int prev[]=new int[b];
        for(int i=0; i<a; i++){
            int temp[]=new int[b];
            for(int j=0; j<b; j++){
                if(i==0 && j==0){
                    temp[j]=1;
                    continue;
                }
            
                int up=0;
                int left =0;
            
                if(i>0)
                    up = prev[j];
                if(j>0)
                    left = temp[j-1];
                
                temp[j] = up + left;
            }
            prev = temp;
        }
    
        return prev[b-1];
        
    }
    
    public static int recFunc(int a,int b){
        if(a<0 || b<0)return 0;
        if(a==0 && b==0) return 1;
        
        return recFunc(a-1,b)+recFunc(a,b-1);
        
    }
    
    public static int memFunc(int a,int b,int[][] dp){
        if(a<0 || b<0)return 0;
        if(a==0 && b==0)return 1;
        if(dp[a][b]!=-1)return dp[a][b];
        return dp[a][b] = memFunc(a-1,b,dp)+memFunc(a,b-1,dp);
    }
    
}