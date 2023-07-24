//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][m];
            
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt ();

    		System.out.println (new Sol().maxOnes (arr, n, m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int maxOnes (int arr[][], int n, int m)
    {
        int maxi = 0;
        int maxRow = -1;
        int i = 0;
        int j = m-1;
        while(i<n && j>=0){
            if(arr[i][j]==1){
                if(m-j>maxi){
                    maxi = m-j;
                    maxRow = i;
                }
                j--;
            }else i++;
        }
        return maxRow;
    }
}