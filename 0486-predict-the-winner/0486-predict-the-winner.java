class Solution {
    private int recFunc(int l,int h,int[] nums,int flag){
        if(l>h)return 0;
        if(l==h)return nums[l];

        int pickL = nums[l] - recFunc(l+1,h,nums,flag);
        int pickR = nums[h] - recFunc(l,h-1,nums,flag);

        return Math.max(pickL,pickR);

    }
    public boolean PredictTheWinner(int[] nums) {
        int res = recFunc(0,nums.length-1,nums,0);
        return res>=0;
    }
}