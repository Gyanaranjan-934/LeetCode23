//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int tar) 
	{ 
	    // 1. Recursion + Tabulation
	   // int[][] dp = new int[n][tar+1];
	   // for(int[] row : dp)
	   //     Arrays.fill(row,-1);
	   // return recFunc(n-1,arr,tar,dp);
	   
	   //// 2. Tabulation
	   int[][] dp = new int[n+1][tar+1];
	   for(int j=1;j<=tar;j++)
	        dp[0][j] = 0;
	    dp[0][0] = 1;
	    
	    // tabulation
	    for(int i=1;i<=n;i++){
	        for(int j=0;j<=tar;j++){
	            if(arr[i-1] > j){
	                dp[i][j] = dp[i-1][j];
	            }
	            else{
	                dp[i][j] = (dp[i-1][j-arr[i-1]] + dp[i-1][j])%1000000007;
	            }
	        }
	    }
	    
	    return dp[n][tar];
	    
	} 
	
	public int recFunc(int ind,int[] arr,int tar,int[][] dp){
        if(ind == 0){
            if(tar == 0 && arr[0] == 0){
                return 2;
            }
            else if(tar == 0 || arr[0] == tar) return 1;
            return 0;
        }
        if(dp[ind][tar] != -1)return dp[ind][tar];
        int notPick = recFunc(ind-1,arr,tar,dp);
        int pick = 0;
        if(arr[ind]<=tar)
            pick = recFunc(ind-1,arr,tar-arr[ind],dp);
       
        return dp[ind][tar] = (pick%1000000007+notPick%1000000007)%1000000007;
	    
	}
}