class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while(i<n && nums[i]!=1)i++;
        if(i==n)return 0;
        int maxi = 0;
        j = i;
        int cnt = 0;
        int zeroCnt = 0;
        int zeroInd = -1;
        while(j<n){
            if(nums[j]==1)cnt++;
            else{
                if(zeroCnt==0){
                    // cnt++;
                    zeroCnt=1;
                    zeroInd = j;
                }else{
                    maxi = Math.max(maxi,cnt);
                    cnt=0;
                    i=zeroInd;
                    // while(i<n && )
                    j=i;
                    zeroCnt=0;
                }
            }
            j++;
        }
        if(cnt==n)return n-1;
        return Math.max(cnt,maxi);

    }
}