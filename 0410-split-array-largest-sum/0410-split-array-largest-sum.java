class Solution {
    private boolean helper(int mid,int[] arr,int k){
        int subArrCnt=1;
        int sum=0;
        for(int i:arr){
            sum+=i;
            if(sum>mid){
                subArrCnt++;
                sum=i;
            }
        }
        // System.out.println(mid+"->"+subArrCnt);
        return subArrCnt<=k;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int i:nums){
            low = Math.max(i,low);
            high += i;
        }

        while(low<high){
            int mid = (low+high)/2;
            if(helper(mid,nums,k))high=mid;
            else low=mid+1;
        }
        return high;
    }
}