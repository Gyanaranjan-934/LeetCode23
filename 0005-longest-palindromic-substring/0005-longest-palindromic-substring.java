class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxi = 0;
        int start = 0;
        int end = 0;
        for(int i=0;i<n;i++){
            int left = i;
            int right = i;
            while(left>=0 && right<n){
                if(s.charAt(left)!=s.charAt(right))break;
                left--;
                right++;
            }
            
            int len = right-left+1;
            if(len>maxi){
                maxi = len;
                start = left+1;
                end = right;
            }

            left = i;
            right = i+1;
            while(left>=0 && right<n){
                if(s.charAt(left)!=s.charAt(right))break;
                left--;
                right++;
            }
            len = right-left+1;
            if(len>maxi){
                maxi = len;
                start = left+1;
                end = right;
            }
        }
        return s.substring(start,end);
    }
}