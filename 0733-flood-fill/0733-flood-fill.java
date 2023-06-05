class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int[][] ans = image;

        // int iniCol = image[sr][sc];
        // int drow[] = {-1, 0, +1, 0};
        // int dcol[] = {0, +1, 0, -1}; 
        // dfs(sr,sc,ans,image,iniCol,color,drow,dcol);
        // return ans;

        int n = image.length, m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        
        q.add(new int[]{sr, sc});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] point = q.poll();
                for(int j=0;j<4;j++){
                    int x = point[0] + row[j];
                    int y = point[1] + col[j];
                    if(x>=0 && x<n && y >= 0 && y < m && image[x][y] == oldColor && image[x][y] != color){
                        image[x][y] = color;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        
        return image;

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