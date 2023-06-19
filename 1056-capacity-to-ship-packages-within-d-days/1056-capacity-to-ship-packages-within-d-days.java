class Solution {
    private int helper(int wt,int[] arr){
        int subArrCnt = 1;
        int totWt = 0;
        for(int i:arr){
            totWt+=i;
            
            if(totWt>wt){
                subArrCnt++;
                totWt=i;
            }
        }

        return subArrCnt;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;
        for(int i:weights){
            high+=i;
            low = Math.max(low,i);
        }
        while(low<high){
            int mid = (low+high)/2;
            int ans = helper(mid,weights);
            if(ans<=days)high=mid;
            else low=mid+1;
        }
        return low;
    }
}