class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        // 1. Recursion + Memoization
        // int[][] dp = new int[s1.length()][s2.length()];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        // return recFunc(s1.length()-1,s2.length()-1,s1,s2,dp);

        // 2. Tabulation
        // int n = s1.length()+1;
        // int m = s2.length()+1;
        // int[][] dp = new int[n][m];

        // for(int i=1;i<n;i++){
        //     for(int j=1;j<m;j++){
        //         if(s1.charAt(i-1)==s2.charAt(j-1))
        //             dp[i][j] = 1 + dp[i-1][j-1];
        //         else
        //             dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        //     }
        // }
        // return dp[n-1][m-1];

        // 3. Space Optimization
        int n=s1.length();
        int m=s2.length();
        
        // Base Case is covered as we have initialized the prev and cur to 0.
        int prev[]=new int[m+1];
        int cur[]=new int[m+1];
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    cur[ind2] = 1 + prev[ind2-1];
                else
                    cur[ind2] = 0 + Math.max(prev[ind2],cur[ind2-1]);
            }
            prev=(int[])(cur.clone());
        }
        
        return prev[m];
    }

    public int recFunc(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind1<0 || ind2<0)return 0;

        if(dp[ind1][ind2] != -1)return dp[ind1][ind2];

        if(s1.charAt(ind1)==s2.charAt(ind2))return dp[ind1][ind2] = 1 + recFunc(ind1-1,ind2-1,s1,s2,dp);
        return dp[ind1][ind2] = Math.max(recFunc(ind1-1,ind2,s1,s2,dp),recFunc(ind1,ind2-1,s1,s2,dp));
    }
}