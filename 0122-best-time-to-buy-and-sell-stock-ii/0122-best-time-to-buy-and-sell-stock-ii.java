class Solution {
    private int recFunc(int ind,int[] prices,int[][] dp,int buyStat){
        if(ind==prices.length)return 0;
        if(buyStat==1){
            int buy = -prices[ind]+recFunc(ind+1,prices,dp,0);
            int notBuy = recFunc(ind+1,prices,dp,1);
            return dp[ind][buyStat]=Math.max(buy,notBuy);
        }else{
            int sell = prices[ind]+recFunc(ind+1,prices,dp,1);
            int notSell = recFunc(ind+1,prices,dp,0);
            return dp[ind][buyStat]=Math.max(sell,notSell);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n+1][2];
        // for(int[] row:dp)Arrays.fill(row,-1);
        // return recFunc(0,prices,dp,1);

        int[][] dp = new int[n+1][2];
        for(int ind=n-1;ind>=0;ind--){
            for(int buyStat=1;buyStat>=0;buyStat--){
                if(buyStat==1){
                    int buy = -prices[ind]+dp[ind+1][0];
                    int notBuy = dp[ind+1][1];
                    dp[ind][buyStat]=Math.max(buy,notBuy);
                }else{
                    int sell = prices[ind]+dp[ind+1][1];
                    int notSell = dp[ind+1][0];
                    dp[ind][buyStat]=Math.max(sell,notSell);
                }
            }
        }
        return dp[0][1];
    }
}