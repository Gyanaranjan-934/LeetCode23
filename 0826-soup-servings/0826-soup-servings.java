class Solution {
    private double recFunc(int a,int b,double[][] dp){

        if(a<=0 && b<=0)return 0.5;
        else if(a<=0 && b!=0)return 1;
        else if(a!=0 && b<=0)return 0;
        if(dp[a][b]!=-1.0)return dp[a][b];
        return dp[a][b] = 0.25*(recFunc(a-100,b,dp)+recFunc(a-75,b-25,dp)+recFunc(a-50,b-50,dp)+recFunc(a-25,b-75,dp));
    }
    public double soupServings(int n) {
        if(n>4800)return 1.0;
        double[][] dp = new double[n+1][n+1];
        for(double[] row : dp)Arrays.fill(row,-1.0);
        return recFunc(n,n,dp);
    }
}