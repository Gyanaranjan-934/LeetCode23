class Solution {
    private int findTime(int[] piles,int speed){
        int cnt = 0;
        for(int i:piles){
            if(i%speed==0)cnt+=i/speed;
            else{
                cnt += (i/speed)+1;
            }
        }
        return cnt;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        int low = 1;
        int high = piles[n-1];
        int ans = h;
        while(low<high){
            int mid = (low+high)/2;
            int midHr = findTime(piles,mid);
            if(midHr>h)low=mid+1;
            else high=mid;
        }
        return high;
        
    }
}