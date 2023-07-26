//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            int C = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            out.println(ob.inSequence(A, B, C));
        }
        out.close();
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static int inSequence(int A, int B, int C){
        if(B<A && C>0)return 0;
        else if(C<0 && B>A)return 0;
        int a = A;
        int d = C;
        if(d==0){
            return A==B ? 1 : 0;
        }
        double nth = (B-a)/(double)d;
        if(Math.ceil(nth)==nth)return 1;
        return 0;
    }
}