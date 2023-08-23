class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        char[] arr = new char[n];
        int[] hash = new int[26];
        int maxFreq = 0;
        char maxChar = '_';
        for(char ch : s.toCharArray()){
            hash[ch-'a']++;
            if(hash[ch-'a']>maxFreq){
                maxFreq = hash[ch-'a'];
                maxChar = ch;
            }
        }

        if(maxFreq>(n+1)/2)return "";

        int k = 0;
        while(hash[maxChar-'a'] > 0){
            arr[k] = maxChar;
            k+=2;
            hash[maxChar-'a']--;
        }

        for(int i=0;i<26;i++){
            while(hash[i] > 0){
                if(k>=n)k=1;
                arr[k] = (char) (i + 'a');
                k+=2;
                hash[i]--;
            }
        }

        return String.valueOf(arr);
    } 
}