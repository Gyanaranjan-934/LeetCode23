//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    private static boolean helper(int dist,int cows,int[] arr){
        int cowsCnt=1;
        int i=1;
        int cowInd = 0;
        while(i<arr.length){
            if(arr[i]-arr[cowInd]>=dist){
                cowsCnt++;
                cowInd=i;
            }
            i++;
        }
        return cowsCnt>=cows;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low = 0, high = stalls[n - 1] - stalls[0];
        while(low<=high){
            int mid = low+(high-low)/2;
            boolean ans = helper(mid,k,stalls);
            if(ans)low=mid+1;
            else high=mid-1;
        }
        return high;
    }
}