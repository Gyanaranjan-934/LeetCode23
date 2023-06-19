//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    private static boolean helper(int pages,int[] arr,int m){
        int studCnt = 1;  int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>pages){
                studCnt++;
                sum = arr[i];
            }
        }
        return studCnt<=m;
    }
    
    //Function to find minimum number of pages.
    public static int findPages(int[] arr,int n,int m)
    {
        if(n<m)return -1;
        int low = 1;
        int high = 0;
        for(int i:arr){
            low = Math.max(low,i);
            high+=i;
        }
        
        while(low<high){
            int mid = low+(high-low)/2;
            boolean ans = helper(mid,arr,m);
            if(ans)high=mid;
            else low = mid+1;
        }
        return low;
        
    }
};