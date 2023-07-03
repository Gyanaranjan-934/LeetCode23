class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 0;
        int start = 0;
        int end = 1;
        int n = s.length();
        for(int i=0;i<n;i++){
            // odd length palindrom
            int l = i;
            int r = i;
            while(l>=0 && r<n){
                if(s.charAt(l)!=s.charAt(r))break;
                l--;
                r++;
            }
            int len = r-l-1;
            if(len>maxlen){
                maxlen = len;
                start = l+1;
                end = r;
            }
            
            // even length palindrom
            l = i;
            r = i+1;
            while(l>=0 && r<n){
                if(s.charAt(l)!=s.charAt(r))break;
                l--;
                r++;
            }
            len = r-l-1;
            if(len>maxlen){
                maxlen = len;
                start = l+1;
                end = r;
            }
        }
        return s.substring(start,end);
    }
}