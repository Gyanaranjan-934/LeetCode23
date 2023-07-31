class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        

        
        int n = arr1.length;
        int m = arr2.length;

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr1[i-1]==arr2[j-1])
                    dp[i][j] = arr2[j-1] + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        int lcs = dp[n][m] ;

        int sum = 0;
        for(char ch : arr1)sum+=ch;
        for(char ch : arr2)sum+=ch;

        return (sum - 2*lcs);

    }
}