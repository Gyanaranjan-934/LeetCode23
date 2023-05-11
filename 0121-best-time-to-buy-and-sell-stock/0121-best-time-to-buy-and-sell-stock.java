class Solution {
    public int maxProfit(int[] arr) {
        int profit = 0;
        int mini = arr[0];
        for(int i=0;i<arr.length;i++){
            mini = Math.min(arr[i],mini);
            profit = Math.max(profit,arr[i]-mini);
        }
        return profit;
    }
}