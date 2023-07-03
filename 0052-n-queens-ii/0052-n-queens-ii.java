class Solution {
    private boolean isSafe(int row, int col, List<char[]> list) {
        int drow = row;
        int dcol = col;

        // Check top-left diagonal
        while (row >= 0 && col >= 0) {
            if (list.get(row)[col] == 'Q') return false;
            row--;
            col--;
        }

        // Check top row
        row = drow;
        col = dcol;
        while (row >= 0) {
            if (list.get(row)[col] == 'Q') return false;
            row--;
        }

        // Check top-right diagonal
        row = drow;
        col = dcol;
        while (row >= 0 && col < list.size()) {
            if (list.get(row)[col] == 'Q') return false;
            row--;
            col++;
        }

        return true;
    }

    private void recFunc(int ind, int n, List<char[]> list, int[] res) {
        if (ind == n) {
            res[0]++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(ind, i, list)) {
                list.get(ind)[i] = 'Q';
                recFunc(ind + 1, n, list, res);
                list.get(ind)[i] = '.';
            }
        }
    }

    public int totalNQueens(int n) {
        int[] res = new int[1];
        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            list.add(arr);
        }
        recFunc(0, n, list, res);
        return res[0];
    }
}
