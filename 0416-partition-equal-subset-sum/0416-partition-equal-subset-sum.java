class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum =0;
        for(int i:arr)
            sum+= i;
        if(n==1)return false;
        if(sum%2!=0)return false;
        sum/=2;
	   // 1. Recursion + Memoization
	   int[][] dp = new int[n][sum+1];
	   
	   for(int[] row : dp)
	    Arrays.fill(row,-1);
	   return recFunc(n-1,sum,arr,dp);
    }
    private boolean recFunc(int ind,int sum,int[] arr,int[][] dp){
        if(ind<0)return false;
        if(sum==0)return true;
        if(dp[ind][sum]!=-1)return dp[ind][sum]==0 ? false : true;
        boolean notPick = recFunc(ind-1,sum,arr,dp);
        boolean pick = false;
        if(arr[ind]<=sum)
            pick = recFunc(ind-1,sum-arr[ind],arr,dp);
        boolean res = pick||notPick;
        dp[ind][sum]=res==true?1:0;
        return res;
    }
}