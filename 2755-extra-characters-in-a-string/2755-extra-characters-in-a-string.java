class Solution {
    private int recFunc(int ind,String s,HashSet<String> set,int[] dp){
        if(ind==s.length())return 0;
        if(dp[ind]!=-1)return dp[ind];
        int pick = s.length();
        for(int i=ind+1;i<=s.length();i++){
            String temp = s.substring(ind,i);
            if(set.contains(temp)){
                pick = Math.min(pick,recFunc(i,s,set,dp));
            }
        }
        int notPick = 1 + recFunc(ind+1,s,set,dp);

        return dp[ind] = Math.min(pick,notPick);
    }
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> set = new HashSet<>();
        for(String str : dictionary)set.add(str);
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return recFunc(0,s,set,dp);
    }
}