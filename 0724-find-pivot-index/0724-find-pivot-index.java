class Solution {
    public int pivotIndex(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int leftCnt = 0;
            int rightCnt = 0;
            if(i>0)
                leftCnt = nums[i-1];
            if(i<nums.length-1)
                rightCnt = nums[nums.length-1]-nums[i];

            if(leftCnt==rightCnt)return i;
        }
        return -1;
    }
}