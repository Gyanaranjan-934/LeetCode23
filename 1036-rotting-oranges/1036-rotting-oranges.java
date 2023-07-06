class Pair{
    int row;
    int col;
    Pair(int a,int b){
        this.row = a;
        this.col = b;
    }
}
class Solution {
    private boolean isValid(int i,int j,int[][] grid,int[][] visited){
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || i>=n || j<0 || j>=m)return false;
        if(grid[i][j]!=1)return false;
        if(visited[i][j]==1)return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int freshorenges= 0;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)freshorenges++;
                else if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        if(freshorenges==0)return 0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        int cnt = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                int srow = p.row;
                int scol = p.col;
                for(int k=0;k<4;k++){
                    int nrow = srow + drow[k];
                    int ncol = scol + dcol[k];

                    if(isValid(nrow,ncol,grid,visited)){
                        visited[nrow][ncol] =1;
                        q.add(new Pair(nrow,ncol));
                        freshorenges--;
                    }
                }
            }
            cnt++;
        }
        return freshorenges==0 ? cnt-1 : -1;
    }
}