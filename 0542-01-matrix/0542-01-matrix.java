class Tuple{
    int row;
    int col;
    int val;
    Tuple(int row,int col,int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];
        int[][] visited = new int[n][m];
        Queue<Tuple> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Tuple(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty()){
            Tuple t = q.poll();
            for(int i=0;i<4;i++){
                int nrow = t.row + drow[i];
                int ncol = t.col + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0){
                    visited[nrow][ncol] = 1;
                    res[nrow][ncol]=t.val+1;
                    q.add(new Tuple(nrow,ncol,t.val+1));
                }
            }
        }

        return res;
    }
}