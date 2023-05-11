class Solution {
    public int maxProfit(int[] arr) {
        // 1. Recursion + Memoization
        // int[][] dp = new int[arr.length+1][2];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        
        // return recFunc(0,arr,1,dp);

        // 2. Tabulation
        // int[][] dp = new int[arr.length+1][2];
        
        // for(int i=arr.length-1;i>=0;i--){
        //     for(int j=0;j<=1;j++){
        //         if(j==1){
        //             int buyIt = -arr[i]+dp[i+1][0];
        //             int notBuyIt = dp[i+1][1];
        //             dp[i][j] = Math.max(buyIt,notBuyIt);
        //         }else{
        //             int sellIt = arr[i]+dp[i+1][1];
        //             int notSellIt = dp[i+1][0];
        //             dp[i][j] = Math.max(sellIt,notSellIt);
        //         }                
        //     }
        // }
        // return dp[0][1];
        
        // Space Optimization 1
        // int[] prev = new int[2];
        // int[] curr = new int[2];
        // for(int i=arr.length-1;i>=0;i--){
        //     for(int j=0;j<=1;j++){
        //         if(j==1){
        //             int buyIt = -arr[i]+prev[0];
        //             int notBuyIt = prev[1];
        //             curr[j] = Math.max(buyIt,notBuyIt);
        //         }else{
        //             int sellIt = arr[i]+prev[1];
        //             int notSellIt = prev[0];
        //             curr[j] = Math.max(sellIt,notSellIt);
        //         }
        //     }
        //     prev = (int[])(curr.clone());
        // }
        // return prev[1];

        // Space Optimization 2

        int aheadNotBuy = 0 , aheadBuy=0;
        int currNotBuy = 0,currBuy = 0;
        for(int i=arr.length-1;i>=0;i--){

            currNotBuy = Math.max(arr[i]+aheadBuy,aheadNotBuy);
            
            currBuy = Math.max(-arr[i]+aheadNotBuy,aheadBuy);  

            aheadBuy = currBuy;
            aheadNotBuy=currNotBuy;
        }
        return aheadBuy;

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