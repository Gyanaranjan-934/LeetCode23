class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int k = 1;
        int pow = n*n;
        for(int i=0;i<=(n-1)/2;i++){
            // print upper
            int j = i;
            while(j<n-i && k<=pow){
                // if(arr[i][j] != 0)break;
                arr[i][j] = k++;
                System.out.println(arr[i][j]);
                j++;
            }
            // print right
            j = i+1;
            while(j<n-i-1 && k<=pow){
                // if(arr[j][n-i-1]!=0)break;
                arr[j][n-i-1] = k++;
                System.out.println(arr[j][n-i-1]);
                j++;
            }
            // print lower
            j=n-i-1;
            while(j>=i && k<=pow){
                // if(arr[j][n-i-1]!=0)break;
                arr[n-i-1][j]=k++;
                System.out.println(arr[n-i-1][j]);
                j--;
            }
            // print left
            j=n-i-2;
            while(j>=i+1 && k<=pow){
                // if(arr[j][n-i-1]!=0)break;
                arr[j][i] = k++;
                System.out.println(arr[j][i]);
                j--;
            }
        }
        return arr;
    }
}