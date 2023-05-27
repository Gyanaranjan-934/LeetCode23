class Solution {
    public int recFunc(int ind,int[] arr,int[] dp){
        if(ind>=arr.length)return 0;
        if(dp[ind]!=-1)return dp[ind];
        int diff = Integer.MIN_VALUE;
        int currSum=0;
        for(int i=0;i<3 && ind+i<arr.length;i++){
            currSum += arr[i+ind];
            int res = recFunc(ind+i+1,arr,dp);
            diff = Math.max(diff,currSum-res);
        }
        return dp[ind] = diff;
    }
    public String stoneGameIII(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1); 
        int res = recFunc(0,arr,dp);
        if(res>0)return "Alice";
        else if(res<0)return "Bob";
        else return "Tie";
    }
}