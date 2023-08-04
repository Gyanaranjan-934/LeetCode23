class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        // int[][] dp = new int[s1.length()][s2.length()];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        // return recFunc(s1.length()-1,s2.length()-1,s1,s2,dp);

        // 2. Tabulation
        // int[][] dp = new int[n+1][m+1];
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=m;j++){
        //         if(i==0)dp[i][j] = j;
        //         if(j==0)dp[i][j] = i;
        //     }
        // }

        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(s1.charAt(i-1)==s2.charAt(j-1))
        //             dp[i][j] = dp[i-1][j-1];
        //         else{
        //             int insert = 1+dp[i][j-1];
        //             int delete = 1+dp[i-1][j];
        //             int replace = 1+dp[i-1][j-1];
                    
        //             dp[i][j] = Math.min(insert,Math.min(delete,replace));
        //         }
        //     }
        // }

        // return dp[n][m];

        // Space Optimization
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        for(int i=1;i<=m;i++)
            prev[i] = i;

        for(int i=1;i<=n;i++){
            curr[0] = i;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    curr[j] = prev[j-1];
                else{
                    int insert = 1 + curr[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1];
                    
                    curr[j] = Math.min(insert,Math.min(delete,replace));
                }
            }
            prev = (int[])(curr.clone());
        }

        return prev[m];
        

    }
    public int recFunc(int ind1,int ind2,String s1, String s2,int[][] dp){
        if(ind2<0)return ind1+1;
        if(ind1<0)return ind2+1;
        
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        
        if(s1.charAt(ind1)==s2.charAt(ind2))
            return dp[ind1][ind2] = recFunc(ind1-1,ind2-1,s1,s2,dp);
        else{
            int insert = 1+recFunc(ind1,ind2-1,s1,s2,dp);
            int delete = 1+recFunc(ind1-1,ind2,s1,s2,dp);
            int replace = 1+recFunc(ind1-1,ind2-1,s1,s2,dp);
            
            return dp[ind1][ind2] = Math.min(insert,Math.min(delete,replace));
        }
        
    }
}