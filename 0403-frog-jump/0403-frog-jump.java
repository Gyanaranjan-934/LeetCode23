class Solution {
    private boolean recFunc(int curr,int prev,int[] arr,int[][] dp){
        if(curr==arr.length-1)return true;
        if(dp[curr][prev]!=-1)return dp[curr][prev]==0 ? false : true;
        int dist = arr[curr]-arr[prev];

        for(int i=curr+1;i<arr.length;i++){
            if(arr[i]-arr[curr]>=dist-1 && arr[i]-arr[curr]<=dist+1){
                boolean  res = recFunc(i,curr,arr,dp);
                if(res){
                    dp[curr][prev] = 1;
                    return true;
                }
            }
        }
        dp[curr][prev] = 0;
        return false;
    }
    public boolean canCross(int[] stones) {
        if(stones[1]-stones[0]!=1)return false;
        int n = stones.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp)Arrays.fill(row,-1);
        return recFunc(1,0,stones,dp);
    }
}