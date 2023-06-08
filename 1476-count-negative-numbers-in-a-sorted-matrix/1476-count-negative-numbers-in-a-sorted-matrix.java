class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int i = 0;
        int j = m-1;
        int cnt = 0;
        while(i<n && j>=0){
            if(grid[i][j]<0){
                cnt+= (n-i);
                j--;
            }
            else{
                i++;
            }
        }
        return cnt;
    }
}