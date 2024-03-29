//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> res = obj.LargestSubset(N, arr);
            int isValidSeq = 1, sz = res.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    if ((res.get(i) % res.get(j) == 0) ||
                        (res.get(j) % res.get(i) == 0))
                        continue;
                    else {
                        isValidSeq = 0;
                        break;
                    }
                }
            }
            System.out.println(isValidSeq + " " + sz);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> LargestSubset(int N, int[] arr) {
        // Code here
        List<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] hash = new int[n];
        for(int i=0;i<n;i++)
            hash[i]=i;
        int maxi = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]++;
                    hash[i] = j;
                }
            }
            if(dp[i]>dp[maxi])maxi=i;
        }

        int i=maxi;
        
        while(hash[i]!=i){
            // System.out.println(hash[i]);
            res.add(arr[i]);
            i = hash[i];
        }
        res.add(arr[i]);
        return res;
    }
}
