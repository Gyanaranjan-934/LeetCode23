class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int i=0;
        int j = 0;
        int maxi = 0;
        while(j<n){
            if(arr[j]==0)k--;
            if(k<0){
                maxi = Math.max(maxi,j-i);
                while(i<j && arr[i]!=0)i++;
                i++;
                k++;
            }
            j++;
        }
        maxi = Math.max(maxi,j-i);
        return maxi;
    }
}