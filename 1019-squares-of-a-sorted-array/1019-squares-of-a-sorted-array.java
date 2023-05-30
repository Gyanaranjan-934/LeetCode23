class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sqArr = new int[n];
        int l = 0,r=n-1;
        int k=n-1;
        while(l<=r){
            int sl = nums[l]*nums[l];
            int sr = nums[r]*nums[r];
            if(sl<sr){
                sqArr[k--]=sr;
                r--;
            }else{
                sqArr[k--]=sl;
                l++;
            }
        }
        return sqArr;
    }
}