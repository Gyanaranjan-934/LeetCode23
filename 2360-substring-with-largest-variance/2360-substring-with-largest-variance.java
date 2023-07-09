class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int ans = 0;
        
        for(char ch1='a';ch1<='z';ch1++){
            for(char ch2='a';ch2<='z';ch2++){

                if(ch1==ch2 || freq[ch1-'a']==0 || freq[ch2-'a']==0)continue;

                for(int cnt=0;cnt<2;cnt++){
                    int cnt1 = 0,cnt2=0;
                    for(int i=0;i<s.length();i++){
                        if(s.charAt(i)==ch1)cnt1++;
                        if(s.charAt(i)==ch2)cnt2++; 

                        if(cnt1<cnt2){
                            cnt1=0;
                            cnt2=0;
                        }

                        if(cnt1>0 && cnt2>0){
                            ans = Math.max(ans,cnt1-cnt2);
                        }
                    }
                    StringBuffer strBfr = new StringBuffer(s);
                    strBfr.reverse();
                    s = strBfr.toString();
                }

            }
        }
        return ans;
    }
}