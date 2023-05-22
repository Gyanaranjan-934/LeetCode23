class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i : prices){
            min = Math.min(min,i);
            profit = Math.max(profit,i-min);
        }
        return profit;
    }
}