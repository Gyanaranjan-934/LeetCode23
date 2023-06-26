class Pair{
    int val;
    int ind;
    Pair(int a,int b){
        this.val = a;
        this.ind = b;
    }
}
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> minLeft = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minRight = new PriorityQueue<Integer>();
        int leftPtr = 0;
        int rightPtr = costs.length - 1;

        long ans = 0;
        while(k!=0){
            while(minLeft.size()<candidates && leftPtr <= rightPtr){
                minLeft.add(costs[leftPtr]);
                leftPtr++;
            }
            while(minRight.size()<candidates && rightPtr >= leftPtr){
                minRight.add(costs[rightPtr]);
                rightPtr--;
            }

            int a = !minLeft.isEmpty() ? minLeft.peek() : Integer.MAX_VALUE;
            int b = !minRight.isEmpty() ? minRight.peek() : Integer.MAX_VALUE;
            
            if(a<=b){
                ans += (long)minLeft.remove();
            }else{
                ans += (long)minRight.remove();
            }

            k--;
        }
        return ans;
        
    }
}