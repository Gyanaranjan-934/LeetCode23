class Solution {
    public int numDistinct(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        // int[][] dp = new int[n][m];
        // for(int[] row:dp)
        //     Arrays.fill(row,-1);
        // return recFunc(n-1,m-1,s1,s2,dp);


        // 2. Tabulation
        // int[][] dp = new int[n+1][m+1];
        // for(int i=0;i<=n;i++){
        //     dp[i][0] = 1;
        // }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(s1.charAt(i-1)==s2.charAt(j-1)){
        //             dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
        //         }else{
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }
        // return dp[n][m];

        // 3. Space Optimization
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        prev[0] = 1;
        curr[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = prev[j-1]+prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }

        return prev[m];

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