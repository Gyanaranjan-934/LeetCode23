//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            
            int l, r;
            String [] str = br.readLine().trim().split(" ");
            l = Integer.parseInt(str[0]);
            r = Integer.parseInt(str[1]);
            
            Solution obj = new Solution();
            long res = obj.countSubsets(n, arr, l, r);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int recFunc(int ind, int[] arr, int l, int r, long sum) {
        if (ind < 0) {
            return (sum >= l && sum <= r) ? 1 : 0;
        }

        int includeCount = recFunc(ind - 1, arr, l, r, sum + (long) arr[ind]);
        int excludeCount = recFunc(ind - 1, arr, l, r, sum);
        
        return includeCount + excludeCount;
    }

    public static int countSubsets(int n, int[] arr, int l, int r) {
        return recFunc(n - 1, arr, l, r, 0);
    }
}

        
