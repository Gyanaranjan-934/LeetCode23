//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    private static int recFunc(int ind,int[] prices,int buy,int[][] dp){
        if(ind>=prices.length)return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        int res = 0;
        if(buy==0){
            res = Math.max(-1*prices[ind]+recFunc(ind+1,prices,1,dp),recFunc(ind+1,prices,0,dp));
        }else{
            res = Math.max(prices[ind]+recFunc(ind+1,prices,0,dp),recFunc(ind+1,prices,1,dp));
        }
        return dp[ind][buy] = res;
    }
    public static int stockBuyAndSell(int n, int[] prices) {
        int[][] dp = new int[n+1][2];
        for(int[] row: dp)Arrays.fill(row,-1);
        return recFunc(0,prices,0,dp);
    }
}
        
