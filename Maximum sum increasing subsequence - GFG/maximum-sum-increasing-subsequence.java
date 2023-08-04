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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int recFunc(int ind,int[] arr,int prev,int[][] dp){
        if(ind==arr.length)return 0;
        if(dp[prev+1][ind]!=-1)return dp[prev+1][ind] ;
        int notPick = recFunc(ind+1,arr,prev,dp);
        int pick = 0;
        if(prev==-1 || arr[prev]<arr[ind])
            pick = arr[ind]+recFunc(ind+1,arr,ind,dp);
        
        return dp[prev+1][ind] = Math.max(pick,notPick);
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    int[][] dp = new int[n+1][n+1];
	    for(int[] row : dp)Arrays.fill(row,-1);
	    return recFunc(0,arr,-1,dp);
	}  
}