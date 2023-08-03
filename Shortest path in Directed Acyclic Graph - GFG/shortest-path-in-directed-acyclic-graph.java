//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int val;
    int dist;
    Pair(int val,int dist){
        this.val = val;
        this.dist = dist;
    }
}

//User function Template for Java
class Solution {

	public int[] shortestPath(int n,int m, int[][] edges) {
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i=0;i<n;i++){
	        adj.add(new ArrayList<Pair>());
	    }
	    for(int[] row : edges){
	        adj.get(row[0]).add(new Pair(row[1],row[2]));
	    }
	    
	    Queue<Pair> q = new LinkedList<>();
	    int[] dist = new int[n];
	    Arrays.fill(dist,Integer.MAX_VALUE);
	    dist[0] = 0;
	    q.add(new Pair(0,0));
	    while(!q.isEmpty()){
	        Pair temp = q.poll();
	        for(Pair p : adj.get(temp.val)){
	            if(dist[p.val] > dist[temp.val]+p.dist){
	                dist[p.val] = dist[temp.val]+p.dist;
	                q.add(p);
	            }
	        }
	    }
	    
	    for(int i=0;i<n;i++){
	        if(dist[i]==Integer.MAX_VALUE)dist[i]=-1;
	    }
	    
	    return dist;
	}
}