class Pair{
    int row;
    int col;
    int dist;
    Pair(int _row,int _col,int _dist){
        this.row = _row;
        this.col = _col;
        this.dist = _dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    visited[i][j]=1;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;
            int v = p.dist;
            distance[r][c]=v;
            for(int i=0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,v+1));
                }
            }
            
        }
        return distance;
    }
}