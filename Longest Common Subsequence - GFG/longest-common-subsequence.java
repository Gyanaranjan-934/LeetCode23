//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    
    static int lcs(int x, int y, String s1, String s2)
    {
        // 1. Recursion + Memoization
        // int[][] dp = new int[s1.length()][s2.length()];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        // return recFunc(s1.length()-1,s2.length()-1,s1,s2,dp);
        
        // 2. Tabulation
        int n = s1.length()+1;
        int m = s2.length()+1;
        int[][] dp = new int[n][m];
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];

    }
    static int recFunc(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind1<0 || ind2<0)return 0;

        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];

        if(s1.charAt(ind1)==s2.charAt(ind2))return dp[ind1][ind2] = 1 + recFunc(ind1-1,ind2-1,s1,s2,dp);
        return dp[ind1][ind2] = Math.max(recFunc(ind1-1,ind2,s1,s2,dp),recFunc(ind1,ind2-1,s1,s2,dp));
    }
}