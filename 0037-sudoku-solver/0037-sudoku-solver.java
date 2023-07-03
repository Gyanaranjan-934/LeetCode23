class Solution {
    private boolean isSafe(int row,int col,char val,char[][] board){
        int drow = (row/3)*3;
        int dcol = (col/3)*3;

        int srow = row%3;
        int scol = col%3;

        // check in submatrix
        for(int i=drow;i<drow+3;i++){
            for(int j=dcol;j<dcol+3;j++){
                if(board[i][j]==val)return false;
            }
        }

        // check in row/col
        for(int i=0;i<9;i++){
            if(board[row][i]==val || board[i][col]==val)return false;
        }
        return true;

    }
    public void solveSudoku(char[][] board) {
        // Track the solution
        char[][] solution = new char[9][9];

        solve(board, solution);

        // Print or use the solution array
    }

    private boolean solve(char[][] board, char[][] solution) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isSafe(i, j, ch, board)) {
                            board[i][j] = ch;
                            if (solve(board, solution)) {
                                // Solution found, store the final state
                                for (int r = 0; r < 9; r++) {
                                    System.arraycopy(board[r], 0, solution[r], 0, 9);
                                }
                                return true;
                            }
                            board[i][j] = '.';  // Revert the value for backtracking
                        }
                    }
                    return false;  // No valid value found, backtrack
                }
            }
        }
        return true;  // All cells are filled, puzzle is solved
    }
}