class Solution {
    public int maxProfit(int[] arr) {
        // 1. Recursion + Memoization
        int[][] dp = new int[arr.length+2][2];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return recFunc(0,arr,0,dp);
    }
    public int recFunc(int ind,int[] arr,int buy,int[][] dp){
        if(ind>=arr.length)return 0;
        
        if(dp[ind][buy]!=-1)return dp[ind][buy];

        if(buy==0){
            int buyIt = -arr[ind]+recFunc(ind+1,arr,1,dp);
            int notBuy = recFunc(ind+1,arr,0,dp);            
            return dp[ind][buy] = Math.max(buyIt,notBuy);
        }
        else{
            int sellIt = arr[ind]+recFunc(ind+2,arr,0,dp);
            int notSell = recFunc(ind+1,arr,1,dp);            
            return dp[ind][buy] = Math.max(sellIt,notSell);
        }

    }
}