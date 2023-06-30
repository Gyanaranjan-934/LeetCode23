class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi = 0;
        int prev = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            prev = sum;
            sum += nums[i];
            if(sum==prev){
                maxi = Math.max(maxi,sum);
                sum = 0;
            }
        }
        maxi = Math.max(maxi,sum);
        return maxi;
    }
}