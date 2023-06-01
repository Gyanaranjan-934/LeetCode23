class Solution {
    private int xthSmallest(int[] arr,int x){
        int sum=0;
        int i=0;
        while(sum<x){
            sum+=arr[i];
            i++;
        }
        return i-51;
    }
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] freq = new int[101];
        for(int i=0;i<k-1;i++){
            freq[nums[i]+50]++;
        }
        int i=0;
        int j=k-1;
        int[] res = new int[n-k+1];
        while(j<n){
            freq[nums[j]+50]++;
            int temp = xthSmallest(freq,x);
            res[i]=temp<0?temp:0;
            freq[nums[i]+50]--;
            i++;
            j++;
        }
        return res;
    }
}