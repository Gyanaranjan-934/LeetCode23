class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = (int)1e9+7;
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        int sum = 0;
        for(int i : arr){
            sum+=i;
            // if(i%1==1)cnt++;
            if(sum%2==1){
                cnt = (cnt+1)%mod;
            }

            if(map.containsKey(1-(sum%2)))cnt=(cnt+map.get(1-(sum%2)))%mod;
            

            map.put(sum%2,map.getOrDefault(sum%2,0)+1);
        }
        return cnt%mod;
    }
}