class Solution {
    public int minInsertions(String s1) {
        String s2 = "";
        for(int i=s1.length()-1;i>=0;i--){
            s2 += Character.toString(s1.charAt(i));
        }
        
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        int res = dp[n][n];
        
        return s1.length()-res;
    }
}