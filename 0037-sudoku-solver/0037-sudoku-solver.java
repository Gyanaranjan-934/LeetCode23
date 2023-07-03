class Solution {
    private boolean isSafe(int row, int col, char val, char[][] board) {
        int drow = (row / 3) * 3;
        int dcol = (col / 3) * 3;

        int srow = row % 3;
        int scol = col % 3;

        // check in submatrix
        for (int i = drow; i < drow + 3; i++) {
            for (int j = dcol; j < dcol + 3; j++) {
                if(board[i][j]==val) return false;               
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if(board[row][i]==val || board[i][col]==val)return false;
        }

        return true;
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        char ch = Character.forDigit(k, 10);
                        if (isSafe(i, j, ch, board)) {
                            board[i][j] = ch;
                            if (solve(board)) {
                                return true; // Solution found, propagate the result
                            }
                            else board[i][j] = '.'; // Revert the value for backtracking
                        }
                    }
                    return false; // No valid value found, backtrack
                }
            }
        }
        return true; // All cells are filled, puzzle is solved
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
