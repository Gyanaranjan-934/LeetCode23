class Solution {
    public int countNegatives(int[][] grid) {
        int cnt =0;
        for(int[] row : grid)
            for(int i:row)
                if(i<0)cnt++;
        
        return cnt;
    }
}