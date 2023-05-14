class Solution {
    public int minCost(int n, int[] cut) {
        int[] arr = new int[cut.length+2];
        for(int i=1;i<arr.length-1;i++){
            arr[i] = cut[i-1];
        }
        arr[arr.length-1]=n;
        Arrays.sort(arr);
        int[][] dp = new int[arr.length][arr.length];
        for(int[] row :dp)
            Arrays.fill(row,-1);
        return recFunc(1,arr.length-2,arr,dp);
    }
    public int recFunc(int i,int j,int[] arr,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost = arr[j+1]-arr[i-1] + recFunc(i,k-1,arr,dp) 
                                        + recFunc(k+1,j,arr,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
}