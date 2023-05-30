class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        for(int i=1;i<n;i++)arr[i]+=arr[i-1];

        int windSize = n-k;
        if(windSize==0)return arr[n-1];
        int mini = arr[windSize-1];
        for(int i=windSize;i<n;i++){
            mini = Math.min(mini,arr[i]-arr[i-windSize]);
        }

        return arr[n-1]-mini;
    }
}