class Solution {
    private int countSubarraysAtmostKDistinct(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        int n = nums.length;
        int i=0;
        int j = 0;
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>k){
                int temp = map.get(nums[i]);
                if(temp==1)map.remove(nums[i]);
                else map.put(nums[i],temp-1);
                i++;
            }
            if(map.size()<=k)cnt+=(j-i+1);
            j++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return countSubarraysAtmostKDistinct(nums,k)-countSubarraysAtmostKDistinct(nums,k-1);
    }
}