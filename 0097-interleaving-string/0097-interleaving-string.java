class Solution {
    private boolean recFunc(int ind1,String s1,int ind2,String s2,String s3,int[][] dp){
        if(ind1==s1.length())return s2.substring(ind2).equals(s3.substring(ind1+ind2));
        else if(ind2==s2.length())return s1.substring(ind1).equals(s3.substring(ind1+ind2));

        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2]==0 ? false : true;

        boolean res1 = false;
        boolean res2 = false;
        if(s3.charAt(ind1+ind2)==s1.charAt(ind1))
            res1 = recFunc(ind1+1,s1,ind2,s2,s3,dp);
        if(s3.charAt(ind1+ind2)==s2.charAt(ind2))
            res2 = recFunc(ind1,s1,ind2+1,s2,s3,dp);

        dp[ind1][ind2] = res1||res2 ? 1 : 0;

        return res1 || res2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())return false;
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] row : dp)Arrays.fill(row,-1);
        return recFunc(0,s1,0,s2,s3,dp);
    }
}