class Solution {
    public int minimumDeletions(String s) {
        int cntA = 0;
        int cntB = 0;
        int ans = (int)1e6;
        for(char c : s.toCharArray()){
            cntA += c=='a'?1:0;
        }
        ans = cntA;
        for(int i=0;i<s.length();i++){
            cntB += s.charAt(i)=='b'?1:0;
            cntA -= s.charAt(i)=='a'?1:0;
            ans = Math.min(ans,cntA+cntB);
        }
        return ans;
    }
}