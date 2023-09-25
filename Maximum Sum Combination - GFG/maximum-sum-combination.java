//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Tuple{
    int val;
    int rInd;
    int cInd;
    Tuple(int a,int b,int c){
        this.val = a;
        this.rInd = b;
        this.cInd = c;
    }
}

class Solution {
    static List<Integer> maxCombinations(int n, int k, int arr1[], int arr2[]) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->y.val-x.val);
        
        for(int i=0;i<n;i++){
            pq.add(new Tuple(arr1[i]+arr2[n-1],i,n-1));
        }
        
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && res.size()<k){
            Tuple t = pq.poll();
            int rInd = t.rInd;
            int cInd = t.cInd;
            res.add(t.val);
            if(cInd>0)
                pq.add(new Tuple(arr1[rInd]+arr2[cInd-1],rInd,cInd-1));
        }
        return res;
    }
}
