//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] arr) {
        // code here
        Stack<Integer> s = new Stack<>();
        for(int curr:arr){
            if(curr>0)s.push(curr);
            else{
                while(!s.isEmpty() && s.peek()>0 && Math.abs(curr)>s.peek())s.pop();
                if(s.isEmpty() || s.peek()<0)s.push(curr);
                if(s.peek()+curr==0)s.pop();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!s.isEmpty())list.add(s.pop());
        int[] res = new int[list.size()];
        for(int i=res.length-1;i>=0;i--){
            res[res.length-1-i]=list.get(i);
        }
        return res;
    }
}
