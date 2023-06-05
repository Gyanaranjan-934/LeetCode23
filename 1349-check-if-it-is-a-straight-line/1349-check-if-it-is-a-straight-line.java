class Solution {
    public boolean checkStraightLine(int[][] points) {
        int x1 = points[1][0]-points[0][0];
        int y1 = points[1][1]-points[0][1];

        for(int i=1;i<points.length;i++){
            int x = points[i][0]-points[i-1][0];
            int y = points[i][1]-points[i-1][1];

            if(y*x1 != x*y1)return false;
        }
        return true;
    }
}