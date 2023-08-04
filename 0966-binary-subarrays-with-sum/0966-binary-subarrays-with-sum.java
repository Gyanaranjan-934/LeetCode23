class Solution {
    private int findCnt(int[] nums,int goal){
        if(goal<0)return 0;
        int low = 0;
        int high = 0;
        int n = nums.length;
        int curr = 0;
        int res = 0;
        while(high<n){
            curr+=nums[high];
            while(curr>goal){
                curr-=nums[low++];
            }
            res += high-low+1;
            high++;
        }
        return res;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        // return findCnt(nums,goal)-findCnt(nums,goal-1);
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==goal)cnt++;
            }
        }
        return cnt;
    }
}