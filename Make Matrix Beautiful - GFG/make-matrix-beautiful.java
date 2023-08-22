//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int n, int[][] mat) {
        int[] sRow = new int[n];
        int[] sCol = new int[n];
        int maxSum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sRow[i] += mat[i][j];
                sCol[j] += mat[i][j];
                maxSum = Math.max(maxSum,Math.max(sRow[i],sCol[j]));
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(sRow[i]==maxSum || sCol[j]==maxSum)continue;
                int diff = Math.min(maxSum-sRow[i],maxSum-sCol[j]);
                res+=diff;
                sRow[i]+=diff;
                sCol[j]+=diff;
            }
        }
        return res;
    }
}
        
