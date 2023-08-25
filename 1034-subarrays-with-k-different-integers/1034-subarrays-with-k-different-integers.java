class Solution {
    private int findAtMostK(int[] nums, int k){
        if(k<0)return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        int cnt = 0;
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>k){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)map.remove(nums[i]);
                i++;
            }
            cnt+=(j-i+1);
            j++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findAtMostK(nums,k)-findAtMostK(nums,k-1);
    }
}