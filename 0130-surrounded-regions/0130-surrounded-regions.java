class Solution {
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i=0;i<n;i++){
            if(mat[i][0]=='O'){
                dfs(i,0,mat,drow,dcol);
            }
            if(mat[i][m-1]=='O'){
                dfs(i,m-1,mat,drow,dcol);
            }
        }
        for(int i=0;i<m;i++){
            if(mat[0][i]=='O'){
                dfs(0,i,mat,drow,dcol);
            }
            if(mat[n-1][i]=='O'){
                dfs(n-1,i,mat,drow,dcol);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]=='P')mat[i][j]='O';
                else if(mat[i][j]=='O')mat[i][j]='X';
            }
        }
        
    }
    private void dfs(int r,int c,char[][] mat,int[] drow,int[] dcol){
        mat[r][c]='P';
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<4;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]=='O'){
                dfs(nrow,ncol,mat,drow,dcol);
            }
        }
    }
}