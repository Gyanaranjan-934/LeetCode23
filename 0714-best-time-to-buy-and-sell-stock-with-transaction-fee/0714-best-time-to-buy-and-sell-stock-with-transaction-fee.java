class Solution {
    private int recFunc(int ind,int[] prices,int fee,int buyIt,int[][] dp){
        if(ind==prices.length)return 0;
        if(dp[ind][buyIt]!=-1)return dp[ind][buyIt];
        if(buyIt==1){
            int buy = -prices[ind]+recFunc(ind+1,prices,fee,0,dp);
            int notBuy = recFunc(ind+1,prices,fee,1,dp);
            return dp[ind][buyIt] = Math.max(buy,notBuy);
        }else{
            int sell = (prices[ind]-fee)+recFunc(ind+1,prices,fee,1,dp);
            int notSell = recFunc(ind+1,prices,fee,0,dp);
            return dp[ind][buyIt] = Math.max(sell,notSell);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        // for(int[] row:dp)Arrays.fill(row,-1);
        // return recFunc(0,prices,fee,1,dp);
        
        for(int ind=n-1;ind>=0;ind--){
            for(int buyIt=1;buyIt>=0;buyIt--){
                if(buyIt==1){
                    int buy = -prices[ind]+dp[ind+1][0];
                    int notBuy = dp[ind+1][1];
                    dp[ind][buyIt] = Math.max(buy,notBuy);
                }else{
                    int sell = (prices[ind]-fee)+dp[ind+1][1];
                    int notSell = dp[ind+1][0];
                    dp[ind][buyIt] = Math.max(sell,notSell);
                }
            }
        }
        return dp[0][1];

    }
}