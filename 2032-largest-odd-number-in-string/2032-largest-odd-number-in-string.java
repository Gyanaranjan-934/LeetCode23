class Solution {
    public String largestOddNumber(String num) {
        int ind = num.length();
        for(int i=ind;i>0;i--){
            int n = num.charAt(i-1)-'0';
            if(n%2==1)return num.substring(0,i);
        }
        return "";
    }
}