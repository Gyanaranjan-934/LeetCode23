class Solution {
    public int strStr(String b, String a) {
        if(a.length()>b.length())return -1;
        int i = 0;
        while(i<b.length() && a.charAt(0)!=b.charAt(i))i++;
        if(i==b.length() || b.length()-i+1 < a.length())return -1;
        int j = i;
        while(j<b.length()){
            // if(j>=a.length())return i;
            int invalid = 0;
            for(int k=0;k<a.length();k++){
                if(k+j>=b.length() || a.charAt(k)!=b.charAt(k+j)){
                    invalid = 1;
                    break;
                }
            }
            if(invalid==0)return i;
            i++;
            while(i<b.length() && a.charAt(0)!=b.charAt(i))i++;
            j=i;
        }
        return -1;
    }
}