class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxi = 0;
        int cnt = 0;
        int i=0;
        int j=0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                maxi = Math.max(maxi,j-i+1);
            }else{
                while(s.charAt(i)!=s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            j++;
        }
        return maxi;
    }
}