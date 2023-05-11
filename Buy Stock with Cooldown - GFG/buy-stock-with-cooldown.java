//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long arr[], int N){
        // 1. Recursion + Memoization
        // long[][] dp = new long[arr.length+2][2];
        // for(long[] row : dp)
        //     Arrays.fill(row,-1);
        // return recFunc(0,arr,0,dp);
        
        long[][] dp = new long[arr.length+2][2];
        
        for(int i=arr.length-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                if(j==0){
                    dp[i][j] = Math.max(-arr[i]+dp[i+1][1],dp[i+1][0]);
                }else
                    dp[i][j] = Math.max(arr[i]+dp[i+2][0],dp[i+1][1]);
            }
        }
        return dp[0][0];
        
    }
    public long recFunc(int ind,long[] arr,int buy,long[][] dp){
        if(ind>=arr.length)return 0;
        
        if(dp[ind][buy]!=-1)return dp[ind][buy];

        if(buy==0){
            long buyIt = -arr[ind]+recFunc(ind+1,arr,1,dp);
            long notBuy = recFunc(ind+1,arr,0,dp);            
            return dp[ind][buy] = Math.max(buyIt,notBuy);
        }
        else{
            long sellIt = arr[ind]+recFunc(ind+2,arr,0,dp);
            long notSell = recFunc(ind+1,arr,1,dp);            
            return dp[ind][buy] = Math.max(sellIt,notSell);
        }

    }
}
