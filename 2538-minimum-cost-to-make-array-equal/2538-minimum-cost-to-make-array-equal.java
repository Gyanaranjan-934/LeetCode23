class Solution {
    public long f(int[] A, int[] cost, int x) {
        long res = 0;
        for (int i = 0; i < A.length; ++i)
            res += 1L * Math.abs(A[i] - x) * cost[i];
        return res;
    }
    
    public long minCost(int[] A, int[] cost) {
        long l = 1, r = 1000000, res = f(A, cost, 1), x;
        while (l < r) {
            x = (l + r) / 2;
            long y1 = f(A, cost, (int) x);
            long y2 = f(A, cost, (int) (x + 1));
            res = Math.min(y1, y2);
            if (y1 < y2)
                r = x;
            else
                l = x + 1;
        }
        return res;
    }
}
