class Solution {
    private void dfs(int sr,int sc,char[][] board){
        board[sr][sc] = 'P';
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<4;i++){
            int nrow = sr + drow[i];
            int ncol = sc + dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O')
                dfs(nrow,ncol,board);
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            if(board[i][0]=='O')dfs(i,0,board);
            if(board[i][m-1]=='O')dfs(i,m-1,board);
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O')dfs(0,i,board);
            if(board[n-1][i]=='O')dfs(n-1,i,board);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='P')board[i][j]='O';
                else if(board[i][j]=='O')board[i][j]='X';
            }
        }

        // return boar
    }
}