class Solution {
    private boolean findRes(int day,int[] arr, int m, int k){
        int subArrCnt=0;
        int minDay = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day)minDay++;
            else{
                if(minDay>=k)subArrCnt++;
                minDay=0;
            }
            if(minDay>=k){
                subArrCnt++;
                minDay=0;
            }
        }
        if(minDay>=k)subArrCnt++;
        // System.out.println(day+"->"+subArrCnt);
        return subArrCnt>=m;
    }
    public int minDays(int[] arr, int m, int k) {
        // System.out.println(m*k);
        if((long)m*(long)k>(long)arr.length){
            return -1;
        }
        int low = arr[0];
        int high = arr[0];

        for(int i:arr){
            low = Math.min(low,i);
            high = Math.max(high,i);
        }
        
        while(low<high){
            int mid = (low+high)/2;
            boolean ans = findRes(mid,arr,m,k);

            if(ans)high=mid;
            else low=mid+1;
        }
        return low;
    }
}