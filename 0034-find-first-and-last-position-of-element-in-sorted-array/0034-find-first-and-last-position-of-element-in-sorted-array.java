class Solution {
    public int[] searchRange(int[] arr, int tar) {
        int n = arr.length;
        int[] res = new int[2];
        Arrays.fill(res,-1);
        int lo=0,hi=n-1;
        // finding lower occurance
        while(lo<=hi){
            int mid = lo+((hi-lo)/2);
            if(arr[mid]<=tar)lo=mid+1;
            else hi=mid-1;
        }
        if(hi>=0 && hi<n && arr[hi]==tar)res[1]=hi;

        // finding upper occurace
        lo=0;
        hi=n-1;
        while(lo<=hi){
            int mid = lo+((hi-lo)/2);
            if(arr[mid]<tar)lo=mid+1;
            else hi=mid-1;
        }
        if(lo>=0 && lo<n && arr[lo]==tar)res[0]=lo;

        return res;
    }
}