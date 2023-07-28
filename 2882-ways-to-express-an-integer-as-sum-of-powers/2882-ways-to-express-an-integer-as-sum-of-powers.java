class Solution {
    int mod = (int)1e9+7;
    private int recFunc(int num,int tar,int n,int x,int[][] dp){
        
        if(tar==0)return 1;
        if(num>n)return 0;
        
        
        if(dp[num][tar]!=-1)return dp[num][tar];
        
        int power = (int)Math.pow(num,x)%mod;
        
        int cnt1 = recFunc(num+1,tar,n,x,dp)%mod;
        int cnt2 = 0;
        if(tar-power >= 0)
            cnt2 = recFunc(num+1,tar-power,n,x,dp)%mod;
        
        return dp[num][tar] = (cnt1+cnt2)%mod;
    }
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp)Arrays.fill(row,-1);
        return recFunc(1,n,n,x,dp);
    }
}