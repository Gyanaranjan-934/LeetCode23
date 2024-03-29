//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // int[][] dp = new int[N][N];
        // for(int[] row :dp)
        //     Arrays.fill(row,-1);
        // return recFunc(1,N-1,arr,dp);
        
        int[][] dp = new int[N][N];
        int n = N;
            for(int i=n-1;i>=1;i--){
                for(int j=i+1;j<n;j++){
                   int mini = Integer.MAX_VALUE;
        
                    // partioning loop
                    for(int k = i; k<= j-1; k++){
                        
                        int ans = dp[i][k]+ dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                            
                        mini = Math.min(mini,ans);
                        
                    }
                    
                    dp[i][j] = mini;
            }   
        }
        
        return dp[1][n-1];
        
    }
    static int recFunc(int i,int j,int[] arr,int[][] dp){
        // if(i==j)return 0;
        // if(dp[i][j]!=-1)return dp[i][j];
        // int mini = Integer.MAX_VALUE;
        // for(int k=i;k<j-1;k++){
        //     int steps =  recFunc(i,k,arr,dp)+recFunc(k+1,j,arr,dp) +(arr[i-1]*arr[k]*arr[j]) ;
        //     mini = Math.min(mini,steps);
        // }
        // return mini;
        
        if(i == j)
        return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int mini = Integer.MAX_VALUE;
        
        // partioning loop
        for(int k = i; k<= j-1; k++){
            
            int ans = recFunc(i,k,arr,dp) + recFunc(k+1,j,arr,dp) + arr[i-1]*arr[k]*arr[j];
                
            mini = Math.min(mini,ans);
            
        }
        
        return dp[i][j] = mini;
        
    }
}