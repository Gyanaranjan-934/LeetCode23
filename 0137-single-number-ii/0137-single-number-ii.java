class Solution {
    public int singleNumber(int[] nums) {
        // brute force hashmap O(N)time O(N)space
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i:nums)map.put(i,map.getOrDefault(i,0)+1);
        // for(int i:nums)if(map.get(i)==1)return i;
        // return -1;

        // better solution O(32N) time O(1) space
        // int ans = 0;
        // for(int i=0;i<32;i++){
        //     int sum = 0;
        //     for(int j=0;j<nums.length;j++){
        //         if(((nums[j] >> i) & 1) == 1){
        //             sum++;
        //             sum%=3;
        //         }
        //     }
        //     if(sum != 0){
        //         ans |= sum << i;
        //     }
        // }
        // return ans;

        // optimal solution O(n) time O(1) space
        int ones = 0,twos = 0;
        for(int i:nums){
            ones = (ones ^ i) & ~twos;
            twos = (twos ^ i) & ~ones;
        }
        return ones;
    }
}