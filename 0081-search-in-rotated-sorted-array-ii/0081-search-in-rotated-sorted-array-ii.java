class Solution {
    public boolean search(int[] arr, int tar) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]==tar)return true;
            if((arr[mid]== arr[lo]) && (arr[mid]==arr[hi])){
                lo++;
                hi--;
            }
            else if(arr[lo]<=arr[mid]){
                if(arr[lo]<=tar && tar<arr[mid])
                    hi=mid-1;
                else lo=mid+1;
            }else{
                if(arr[mid]<tar && tar<=arr[hi])
                    lo=mid+1;
                else hi=mid-1;
            }
        }
        return false;
    }
}