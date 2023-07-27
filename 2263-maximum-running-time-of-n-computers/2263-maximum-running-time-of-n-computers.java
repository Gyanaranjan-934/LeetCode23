class Solution {
    boolean isPossible( int computers,int[] batteries,long time) {
        long totTime = 0;

        for (long bTime : batteries) {
            if (bTime < time)
                totTime += bTime;
            else
                totTime += time;
        }

        return (totTime >= time * computers);
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