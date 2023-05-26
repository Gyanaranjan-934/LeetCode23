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
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int[] arr, int n)
    {
        // if(arr[0]!=arr[1]){ // for starting two element  comparision
        //     return arr[0];
        // }
        // if(arr[n-2]!=arr[n-1]){ // for ending two element comparision
        //     return arr[n-1];
        // }
        // int low=0;
        // int high=n-1;
        // while(low<=high){
        //     int mid = (low+high)/2;
        //     if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1])
	       //     return arr[mid];
        //     if(mid%2==0){
        //         if(arr[mid]==arr[mid+1]){
        //             low=mid+2;
        //         }else{
        //             high=mid;
        //         }
        //     }else{
        //         if(arr[mid]==arr[mid-1]){
        //             low=mid+1;
        //         }else{
        //             high=mid-1;
        //         }
        //     }
        // }
        // return arr[low];
        if(n==1){ 
            return arr[0];
        }
        if(arr[0]!=arr[1]){ // for starting two element  comparision
            return arr[0];
        }
        if(arr[n-2]!=arr[n-1]){ // for ending two element comparision
            return arr[n-1];
        }
        int l = 0,r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1]){
                return arr[mid];
            }
            else if(arr[mid+1]==arr[mid]){
                if((mid+1)%2==0){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else if(arr[mid-1]==arr[mid]){
                if(mid%2==0){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}