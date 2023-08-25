class Solution {
    private int findAtMostK(int[] nums,int k){
        int cnt = 0;
        int temp = 0;
        int i=0,j=0,n=nums.length;
        while(j<n){
            if((nums[j]&1)==1)temp++;
            while(temp>k){
                if((nums[i]&1)==1)temp--;
                i++;
            }
            cnt += (j-i+1);
            j++;
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return findAtMostK(nums,k)-findAtMostK(nums,k-1);
    }
}