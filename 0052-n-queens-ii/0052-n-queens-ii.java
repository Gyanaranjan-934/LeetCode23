class Solution {
    private boolean isSafe(int row, int col, int[][] list) {
        int drow = row;
        int dcol = col;

        // Check top-left diagonal
        while (row >= 0 && col >= 0) {
            if (list[row][col] == 1) return false;
            row--;
            col--;
        }

        // Check top row
        row = drow;
        col = dcol;
        while (row >= 0) {
            if (list[row][col] == 1) return false;
            row--;
        }

        // Check top-right diagonal
        row = drow;
        col = dcol;
        while (row >= 0 && col < list.length) {
            if (list[row][col] == 1) return false;
            row--;
            col++;
        }

        return true;
    }

    private int recFunc(int ind, int n, int[][] list) {
        if (ind == n) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (isSafe(ind, i, list)) {
                list[ind][i] = 1;
                ans += recFunc(ind + 1, n, list);
                list[ind][i] = 0;
            }
        }
        return ans;
    }

    public int totalNQueens(int n) {
        
        int[][] list = new int[n][n];
        return recFunc(0, n, list);
        
    }
}
