class Solution {
    public int maxProfit(int[] arr) {
        int[][] dp = new int[arr.length+1][2];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return recFunc(0,arr,1,dp);
    }
    public int recFunc(int ind,int[] arr,int buy,int[][] dp){
        if(ind==arr.length)return 0;
        if(dp[ind][buy] != -1)return dp[ind][buy];
        if(buy==1){
            int buyIt = -arr[ind]+recFunc(ind+1,arr,0,dp);
            int notBuyIt = recFunc(ind+1,arr,1,dp);
            return dp[ind][buy] = Math.max(buyIt,notBuyIt);
        }else{
            int sellIt = arr[ind]+recFunc(ind+1,arr,1,dp);
            int notSellIt = recFunc(ind+1,arr,0,dp);
            return dp[ind][buy] = Math.max(sellIt,notSellIt);
        }
    }
}