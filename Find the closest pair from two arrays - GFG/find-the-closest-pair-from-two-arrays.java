//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
        public static ArrayList<Integer> printClosest(int arr[], int brr[], int n, int m, int x) {
        int a = 0, b = 0;
        int md = Integer.MAX_VALUE;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (arr[i] + brr[j] == x) {
                return new ArrayList<>(Arrays.asList(arr[i], brr[j]));
            }
            if (Math.abs((arr[i] + brr[j]) - x) < md) {
                md = Math.abs((arr[i] + brr[j]) - x);
                a = arr[i];
                b = brr[j];
            }
            if (arr[i] + brr[j] > x) {
                j--;
            } else {
                i++;
            }
        }
        return new ArrayList<>(Arrays.asList(a, b));
    }
}