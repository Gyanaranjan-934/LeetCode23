//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int recFunc(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind1<0 || ind2<0)return 0;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2) && ind1!=ind2)
            return 1 + recFunc(ind1-1,ind2-1,s1,s2,dp);
        return dp[ind1][ind2] = Math.max(recFunc(ind1-1,ind2,s1,s2,dp),recFunc(ind1,ind2-1,s1,s2,dp));
    }
    
    public int LongestRepeatingSubsequence(String str1)
    {
        // String str2 = "";
        // for(int i=str1.length()-1;i>=0;i--)str2+=str1.charAt(i);
        int[][] dp = new int[str1.length()][str1.length()];
        for(int[] row:dp)Arrays.fill(row,-1);
        return recFunc(str1.length()-1,str1.length()-1,str1,str1,dp);
    }
}