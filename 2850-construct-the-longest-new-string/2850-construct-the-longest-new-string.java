class Solution {
    public int longestString(int x, int y, int z) {
        int xy = Math.min(x,y)*4;
        int newx = x-Math.min(x,y);
        int newy = y-Math.min(x,y);

        xy += z*2;
        if(newx>0)xy+=2;
        else if(newy>0)xy+=2;
        return xy;
    }
}