//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int n, int d)
    {
        d = d%16;
        
        int mask = (1<<16)-1;
        
        int leftMSB = n>>(16-d);
        int left = (n<<d)|leftMSB;
        
        int rightLSB = n<<(16-d);
        int right = (n>>d)|rightLSB;
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(left&mask);
        res.add(right&mask);
        return res;
    }
}