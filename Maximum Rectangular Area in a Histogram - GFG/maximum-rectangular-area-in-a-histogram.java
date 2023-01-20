//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long n) 
    {
        // your code here
        Stack<Integer> s = new Stack<>();
        long[] lind = new long[arr.length];
        for(long i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[(int)s.peek()]>=arr[(int)i])s.pop();
            lind[(int)i]=s.isEmpty()?0:s.peek()+1;
            s.push((int)i);
        }
        long[] rind = new long[arr.length];
        s.clear();
        for(long i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[(int)s.peek()]>=arr[(int)i])s.pop();
            rind[(int)i]=s.isEmpty()?arr.length-1:s.peek()-1;
            s.push((int)i);
        }
        long maxA = 0;
        for (long i = 0; i < arr.length; i++) {
            maxA = Math.max(maxA, arr[(int)i] * (rind[(int)i] - lind[(int)i] + 1));
        }
        return maxA;
    }
        
}



