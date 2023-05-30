class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int i:nums){
            if(i!=0){
                nums[left++]=i;
            }
        }
        for(int i=left;i<nums.length;i++)nums[i]=0;
    }
}