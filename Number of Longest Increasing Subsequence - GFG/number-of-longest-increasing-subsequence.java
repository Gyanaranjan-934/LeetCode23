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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.NumberofLIS(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NumberofLIS(int N, int arr[]){
        int n = N;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        
        int maxi = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    if(dp[j]+1==dp[i])cnt[i]+=cnt[j];
                    else if(dp[j]+1 >dp[i]){
                        dp[i] = dp[j]+1;
                        cnt[i]=cnt[j];
                    }
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        
        // for(int i:dp)
        //     System.out.print(i+" ");
        
        // System.out.println();
        
        // for(int i:cnt)
        //     System.out.print(i+" ");
            
        // System.out.println();
        int res = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi)res+=cnt[i];
        }
        
        return res;
    }
}