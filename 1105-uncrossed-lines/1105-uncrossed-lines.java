class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 1. Recursion 
        // return recFunc(nums1.length-1,nums2.length-1,nums1,nums2);
        
        // 2. Tabulation
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1]==nums2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
    public int recFunc(int ind1,int ind2,int[] arr1,int[] arr2){
        if(ind1<0 || ind2<0)return 0;

        if(arr1[ind1]==arr2[ind2])
            return 1+recFunc(ind1-1,ind2-1,arr1,arr2);
        else{
            return Math.max(recFunc(ind1,ind2-1,arr1,arr2),recFunc(ind1-1,ind2,arr1,arr2));
        }

    }
}