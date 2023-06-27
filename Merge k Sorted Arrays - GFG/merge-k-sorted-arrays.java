//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java
class Pair{
    int val;
    int rInd;
    int cInd;
    Pair(int a,int b,int c){
        this.val = a;
        this.rInd = b;
        this.cInd = c;
    }
}

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.val-y.val);   
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i][0],i,0));
        }
        
        while(!pq.isEmpty() && res.size()!=k*k){
            Pair p = pq.poll();
            res.add(p.val);
            int rInd = p.rInd;
            int cInd = p.cInd;
            if(cInd<k-1)
                pq.add(new Pair(arr[rInd][cInd+1],rInd,cInd+1));
        }
        return res;
    }
}