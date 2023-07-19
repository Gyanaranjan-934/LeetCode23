//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        
        
        int[] minArr = new int[n];
        int[] maxArr = new int[n];
        int mini = arr[0];
        int maxi = arr[n-1];
        for(int i=0;i<n;i++){
            mini = Math.min(mini,arr[i]);
            minArr[i] = mini;
            
            maxi = Math.max(maxi,arr[n-i-1]);
            maxArr[n-i-1] = maxi; 
        }
        
        
        int i=0;
        int j=0;
        maxi = 0;
        
        while(i<n && j<n){
            if(maxArr[j]>=minArr[i]){
                j++;                
            }else{
                i++;
            }
            maxi = Math.max(maxi,j-i-1);
        }
        return maxi;
        
        
    }
}