//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
    int cnt = 0;
    int left = 0;  // left pointer
    int zerosToFlip = 0;  // count of zeros to be flipped
    
    for (int right = 0; right < n; right++) {
        if (arr[right] == 0) {
            zerosToFlip++;
        }
        
        // If zeros to flip exceeds m, move the left pointer forward
        // until the count of zeros to flip becomes <= m
        while (zerosToFlip > m) {
            if (arr[left] == 0) {
                zerosToFlip--;
            }
            left++;
        }
        
        // Update the count of 1s by taking the maximum between the
        // current count and the length of the current subarray
        cnt = Math.max(cnt, right - left + 1);
    }
    
    return cnt;
}

}