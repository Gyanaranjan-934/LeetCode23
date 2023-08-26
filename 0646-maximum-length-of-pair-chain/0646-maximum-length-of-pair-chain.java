class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(x,y)->x[1]-y[1]);
        int[] prev = pairs[0];
        int cnt=0;
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]<=prev[1])cnt++;
            else prev = pairs[i];
        }
        return pairs.length-cnt;
    }
}