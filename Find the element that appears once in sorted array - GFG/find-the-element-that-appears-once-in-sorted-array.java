//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        if(arr.length ==1 )return  arr[0];
        int low = 0,high=arr.length-1;
        while(low <= high)
        {
            if(low == high)return arr[low];
            int mid = low + (high-low)/2;
            
            if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1])return arr[mid];
            
            if(arr[mid]==arr[mid-1])
            {
                int element_left = (mid-1);
                if(element_left % 2 != 0){
                    high = mid - 2;
                }
                else{
                    low = mid+1;    
                }
            }
            else{
                int element_right = (high-mid)+1;
                if(element_right % 2 != 0){
                    low = mid + 2;
                    
                }
                else{
                    high = mid-1;    
                }
            }
        }
        return -1;
    }
}