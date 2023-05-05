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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{
        int sum =0;
        for(int i:arr)
            sum+= i;
        if(n==1)return sum;
	   // 1. Recursion + Memoization
	   int[][] dp = new int[n][sum+1];
	   
	   for(int[] row : dp)
	    Arrays.fill(row,-1);
	   return recFunc(n-1,0,sum,arr,dp);
	} 
	
	public int recFunc(int ind,int s1,int sum,int[] arr,int[][] dp){
	    if(ind<0){
	        int s2 = sum-s1;
	        return Math.abs(s1-s2);
	    }
	    if(dp[ind][s1] != -1)return dp[ind][s1];
	    int pick = recFunc(ind-1,s1+arr[ind],sum,arr,dp);
	    int notPick = recFunc(ind-1,s1,sum,arr,dp);
	    
	    return dp[ind][s1]=Math.min(pick,notPick);
	    
	}
}
