class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;

        int iniCol = image[sr][sc];
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, +1, 0, -1}; 
        dfs(sr,sc,ans,image,iniCol,color,drow,dcol);
        return ans;

    }
    private void dfs(int r,int c,int[][] ans,int[][] image,int iniCol,int newCol,int[] drow,int[] dcol){
        
        ans[r][c]=newCol;
        for(int i=0;i<4;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow >=0 && nrow <ans.length && ncol>=0 && ncol<ans[0].length && image[nrow][ncol]==iniCol && ans[nrow][ncol]!=newCol){
                
                dfs(nrow,ncol,ans,image,iniCol,newCol,drow,dcol);
            }

        }
    }
}