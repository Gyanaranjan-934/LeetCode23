class Solution {
    public long minimumReplacement(int[] nums) {
        if(nums.length==1)return 0;
        long res = 0;
        int i=nums.length-2;
        while(i>=0){
            if(nums[i]>nums[i+1]){
                int temp = nums[i]/nums[i+1];
                if(nums[i]%nums[i+1]!=0)temp++;
                res += (long)temp-1;
                nums[i] = nums[i]/temp;
            }
            i--;
        }
        return res;
    }
}