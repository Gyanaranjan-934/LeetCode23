//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Pair{
    int val;
    int step;
    Pair(int a,int b){
        this.val = a;
        this.step = b;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end)return 0;
        int[] steps = new int[100000];
        steps[start] = 0;
        Arrays.fill(steps,Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,0));
        
        while(!q.isEmpty()){
            int n = q.peek().val;
            int step = q.peek().step;
            q.remove();
            for(int i:arr){
                int temp = (i*n)%100000;
                if(step+1 < steps[temp]){
                    steps[temp] = step+1;
                    q.add(new Pair(temp,step+1));
                }
            }
        }
        return steps[end] == Integer.MAX_VALUE ? -1 : steps[end];
    }
}
