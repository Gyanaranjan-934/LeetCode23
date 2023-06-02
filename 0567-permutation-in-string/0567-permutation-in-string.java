class Solution {
    private boolean compareArr(int[] arr1,int[] arr2){
        for(int i=0;i<arr2.length;i++){
            if(arr1[i]!=arr2[i])return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        
        int[] freq1 = new int[26];
        for (int i = 0; i < s1.length(); i++)
            freq1[s1.charAt(i) - 'a']++;
        
        int[] freq2 = new int[26];
        int windSize = s1.length();
        
        for (int k = 0; k < windSize - 1; k++)
            freq2[s2.charAt(k) - 'a']++;
        
        int i = 0;
        int j = windSize - 1;
        
        while (j < s2.length()) {
            freq2[s2.charAt(j) - 'a']++;
            if (compareArr(freq1, freq2))
                return true;
            
            freq2[s2.charAt(i) - 'a']--;
            i++;
            j++;
        }
        
        return false;
    }

}