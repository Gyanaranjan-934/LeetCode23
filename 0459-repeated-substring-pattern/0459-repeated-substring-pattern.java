class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String a1=s+s;
        String a2=a1.substring(1,a1.length()-1);
        if(a2.contains(s)) return true;
        else return false;
    }
}