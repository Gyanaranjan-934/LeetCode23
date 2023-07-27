class Solution {
    private boolean isPossible(int n,int[] arr,long mid){
        int ptr = arr.length-1;
        while(ptr>=0 && arr[ptr]>=mid && n>0){
            ptr--;
            n--;
        }
        if(n==0)return true;
        if(ptr+1 > n){
            long totsum = 0;
            while(ptr>=0)totsum+=arr[ptr--];
            return totsum>=mid*(long)n;
        }else return false;
    }
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long low = 1;
        long high = 0;
        for(int i: batteries)high+=i;
        long ans = 0;
        while(low<=high){
            long mid = low + (high-low)/2;
            if(isPossible(n,batteries,mid)){
                ans = Math.max(ans,mid);
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans ;
    }

}