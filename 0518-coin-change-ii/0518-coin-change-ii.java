class Solution {
    private int recFunc(int ind,int amt,int[] coins,int[][] dp){
        if(ind<0)return 0;
        if(amt==0)return 1;
        if(dp[ind][amt]!=-1)return dp[ind][amt];
        int notPick = recFunc(ind-1,amt,coins,dp);
        int pick = 0;
        if(amt>=coins[ind])
            pick = recFunc(ind,amt-coins[ind],coins,dp);

        return dp[ind][amt] = pick+notPick;

    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] row : dp)Arrays.fill(row,-1);
        return recFunc(coins.length-1,amount,coins,dp);
    }
}