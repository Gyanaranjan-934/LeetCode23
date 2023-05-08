class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for(int i=0;i<n;i++){
            int d1 = n-1-i;
            if(d1!=i){
                sum = sum + mat[i][i] + mat[i][d1];
            }
            else
                sum = sum + mat[i][i];
        }
        return sum;
    }
}