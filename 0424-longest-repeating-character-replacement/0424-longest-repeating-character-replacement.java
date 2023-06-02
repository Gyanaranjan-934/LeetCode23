class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i=0;
        int maxCnt = 0;
        int maxLen = 0;
        for(int j=0;j<s.length();j++){
            maxCnt = Math.max(maxCnt,++freq[s.charAt(j)-'A']);
            while((j-i+1)-maxCnt>k){
                freq[s.charAt(i)-'A']--;
                i++;
            }
            maxLen = Math.max(maxLen,(j-i+1));
        }
        return maxLen;
    }
}