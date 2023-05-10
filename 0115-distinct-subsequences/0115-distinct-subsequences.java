class Solution {
    public int numDistinct(String s1, String s2) {
        int i = s1.length();
        int j = s2.length();
        int[][] dp = new int[i][j];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return recFunc(i-1,j-1,s1,s2,dp);
    }
    public int recFunc(int ind1,int ind2,String s1, String s2,int[][] dp){
        if(ind2<0)return 1;
        if(ind1<0)return 0;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] = recFunc(ind1-1,ind2-1,s1,s2,dp)+recFunc(ind1-1,ind2,s1,s2,dp);
        }
        else return dp[ind1][ind2] = recFunc(ind1-1,ind2,s1,s2,dp);
    }
}