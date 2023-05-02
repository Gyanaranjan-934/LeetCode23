//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // 1. Recursion
        // if(n<1)return 0;
        // int pick = arr[n-1]+findMaxSum(arr,n-2);
        // int notPick = findMaxSum(arr,n-1);
        // return Math.max(pick,notPick);
        
        // 2. Memoization
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return memFunc(arr,n-1,dp);
        
        // 3. Tabulation
        int[] dp = new int[n];
        dp[0] = 0;
        int negInd = 0;
        
        for(int i=0;i<n;i++){
            int pick = arr[i];
            if(i>1){
                pick += dp[i-2];
            }
            int notPick = 0;
            if(i>0)
                notPick = dp[i-1];
            
            dp[i] = Math.max(pick,notPick);
            
        }
        return dp[n-1];
        
    }
    int memFunc(int[] arr,int n,int[] dp){
        if(n<0)return 0;
        
        if(dp[n]!=-1)return dp[n];
        
        int pick = arr[n]+memFunc(arr,n-2,dp);
        int notPick = memFunc(arr,n-1,dp);
        return dp[n] = Math.max(pick,notPick);
    }
}