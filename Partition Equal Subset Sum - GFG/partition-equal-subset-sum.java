//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution{
    static int equalPartition(int n, int arr[])
    {
        // 1. Recursion + Memoiaztion
        
        int sum =0;
        for(int i:arr)
            sum+= i;
            
        if(sum%2==1)return 0;
        
        int tar = sum/2;
        
        int[][] dp = new int[n][tar+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return recFunc(n-1,arr,tar,dp) == true ? 1 : 0;        
        
    }
    
    static boolean recFunc(int ind,int[] arr,int tar,int[][] dp){
        if(tar==0)return true;
        if(ind==0)return arr[0]==tar;
        
        if(dp[ind][tar]!=-1)return dp[ind][tar]==1?true:false;
        
        boolean notPick = recFunc(ind-1,arr,tar,dp);
        boolean pick = false;
        
        if(tar>=arr[ind])
            pick = recFunc(ind-1,arr,tar-arr[ind],dp);
        
        if(pick||notPick)
            dp[ind][tar] = 1;
        else
            dp[ind][tar] = 0;
        
        return pick||notPick;
    } 
    
}