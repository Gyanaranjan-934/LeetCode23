//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] nums , int N, int tar) {
        int sum = 0;
        for(int i:nums)
            sum+=i;
        
        int k = sum-tar;
        if(k<0 || k%2==1)return 0;

        tar = k/2;
        
        int[][] dp = new int[nums.length][tar+1];

        for(int[] row : dp)
            Arrays.fill(row,-1);
        return recFunc(nums.length-1,nums,tar,dp);  

    }
    static int recFunc(int ind,int[] arr,int tar,int[][] dp){
        if(ind==0){
            if(tar==0 && arr[ind]==0)return 2;
            if(tar==0 || arr[ind]==tar)return 1;
            return 0;
        }

        if(dp[ind][tar]!= -1)return dp[ind][tar];

        int notPick = recFunc(ind-1,arr,tar,dp);
        int pick = 0;
        if(tar>=arr[ind])
            pick = recFunc(ind-1,arr,tar-arr[ind],dp);

        return dp[ind][tar] = pick + notPick;

    }
};