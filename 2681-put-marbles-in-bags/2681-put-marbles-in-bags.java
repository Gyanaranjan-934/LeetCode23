class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        ArrayList<Long> list = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            list.add((long)(weights[i]+weights[i+1]));
        }
        Collections.sort(list);
        long max_sum = 0;
        long min_sum = 0;

        for(int i=0;i<k-1;i++){
            min_sum += list.get(i);
            max_sum += list.get(list.size()-i-1);
        }

        return max_sum-min_sum;
    }
}