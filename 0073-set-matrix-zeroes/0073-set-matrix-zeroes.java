class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        // int[][] matrix = new int[n][m];

        int[] drow = new int[n];
        int[] dcol = new int[m];

        Arrays.fill(drow,-1);
        Arrays.fill(dcol,-1);

        boolean isRow = false;
        boolean isCol = false;

        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                isRow = true;
                break;
            }
        }

        for(int i=0;i<m;i++){
            if(matrix[0][i]==0){
                isCol = true;
                break;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    drow[i] = 0;
                    dcol[j] = 0;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(drow[i]==0 || dcol[j]==0)matrix[i][j]=0;
                
            }
        }
        for(int i=0;i<n;i++){
            if(isRow){
                matrix[i][0]=0;
            }
        }
        for(int i=0;i<m;i++){
            if(isCol){
                matrix[0][i]=0;
            }
        }

        
    }
}