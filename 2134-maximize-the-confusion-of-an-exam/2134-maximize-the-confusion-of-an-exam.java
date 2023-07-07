class Solution {
    private int maximizeCnt(String ans, char ch, int k) {
        int n = ans.length();
        int kcnt = 0;
        int maxi = 0;
        int ptr = 0;
        int cnt = 0;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (ans.charAt(j) != ch) {
                kcnt++;
                if (kcnt > k) {
                    maxi = Math.max(cnt, maxi);
                    while (i < j && ans.charAt(i) == ch) {
                        i++;
                        cnt--;
                    }
                    i++;
                    kcnt--;
                } else {
                    cnt++;
                }
            } else {
                cnt++;
            }
            j++;
        }
        // Update maximum count after the loop completes
        maxi = Math.max(cnt, maxi);
        return maxi;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maximizeCnt(answerKey, 'T', k),maximizeCnt(answerKey, 'F', k));
        
    }
}
