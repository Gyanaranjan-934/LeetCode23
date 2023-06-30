class Solution {
    public long minCost(int[] nums, int x) {
        int[] checked = new int[nums.length];
        Arrays.fill(checked,Integer.MAX_VALUE);

        ArrayList<Integer> cnums = new ArrayList<>();
        for(int i:nums)cnums.add(i);
        for(int i:nums)cnums.add(i);
        long ans = Long.MAX_VALUE ;
        for(int rot=0;rot<nums.length;rot++){
            long sum = 0;
            for(int j=0;j<nums.length;++j){
                if(checked[j] > cnums.get(j+rot))checked[j] = cnums.get(j+rot);
                sum += checked[j];

            }
            sum += (long)rot*(long)x;
            ans = Math.min(ans,sum);
        }

        return ans;

    }
} 