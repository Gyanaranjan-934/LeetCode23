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

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private static int helper(int k,int[] arr){
        int cnt =0;
        for(int i:arr){
            cnt += (int)Math.ceil((double)i/k);
        }
        return cnt;
    }
    public static int smallestDivisor(int[] arr, int k) {
        int low = 1;
        int high = arr[0];
        for(int i:arr)
            high = Math.max(high,i);
        
        while(low<high){
            int mid = (low+high)/2;
            
            int ans = helper(mid,arr);
            if(ans<=k)high=mid;
            else low = mid+1;
        }
        return low;
    }
}