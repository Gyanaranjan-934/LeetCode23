class Solution {
    private int recFunc(int i,int j,char[] arr,int[][] dp){
        if(i==j)return 1;
        // if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int cnt = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = recFunc(i,k,arr,dp) + recFunc(k+1,j,arr,dp);
            cnt = Math.min(cnt,temp);
        }
        return dp[i][j]=arr[i]==arr[j]?cnt-1:cnt;
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