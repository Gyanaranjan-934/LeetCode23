//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private static boolean helper(int day,int m, int k, int[] arr){
        int subArrCnt = 0;
        int minDay = 0;
        for(int i:arr){
            if(i<=day)minDay++;
            else{
                if(minDay>=k)subArrCnt++;
                minDay=0;
            }
            if(minDay>=k){
                subArrCnt++;
                minDay=0;
            }
        }
        return subArrCnt>=m;
    }
    public static int solve(int m, int k, int[] arr) {
       if((long)m*(long)k > (long)arr.length)return -1;
       
       int low = arr[0];
       int high = arr[0];
       
       for(int i:arr){
           low = Math.min(low,i);
           high = Math.max(high,i);
       }
       
       while(low<high){
           int mid = (low+high)/2;
           
           boolean ans = helper(mid,m,k,arr);
           if(ans)high=mid;
           else low=mid+1;
       }
       return low;
       
    }
}