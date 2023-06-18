class Solution {
    public int smallestDivisor(int[] arr, int thres) {
        int low = 1,high = (int)(-1e9);
        for(int i:arr)
            high = Math.max(i,high);
        
        while(low < high){
            // int mid = low + (high-low)/2;
            int mid = (low+high)/2;
            if(check(arr,mid)>thres)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
    public int check(int[] arr,int div){
        int sum=0;
        for(int i:arr){
            sum += (int) Math.ceil((double)i/div);
        }
        return sum;
    }
}