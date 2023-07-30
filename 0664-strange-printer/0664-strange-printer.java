class Solution {
    private int recFunc(int start,int end,char[] arr,int[][] dp){
        if(start==end)return 1;
        if(dp[start][end]!=-1)return dp[start][end];

        int res = 101;
        for(int i=start;i<end;i++){
            res = Math.min(res,recFunc(start,i,arr,dp)+recFunc(i+1,end,arr,dp));
        }
        return dp[start][end]=arr[start]==arr[end]? res-1:res;
    }
    private String setCompressed(String s){
        String res = "";
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1 || s.charAt(i)!=s.charAt(i+1))res+=s.charAt(i);
        }
        return res;
    }
    public int strangePrinter(String s) {

        String compressed = setCompressed(s);
        char[] arr = compressed.toCharArray();

        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] row : dp)Arrays.fill(row,-1);
        return recFunc(0,arr.length-1,arr,dp);
    }
}
