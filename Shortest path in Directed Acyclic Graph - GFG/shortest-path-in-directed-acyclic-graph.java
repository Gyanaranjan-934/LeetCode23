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
    int node;
    int dist;
    Pair(int a,int b){
        this.node = a;
        this.dist = b;
    }
}

//User function Template for Java
class Solution {

	public int[] shortestPath(int n,int m, int[][] edges) {
	    
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0;i<n;i++){
		    adj.add(new ArrayList<Pair>());
		}
		
		for(int[] edge : edges){
		    int u = edge[0];
		    int v = edge[1];
		    int wt = edge[2];
		    
		    adj.get(u).add(new Pair(v,wt));
		}
		
		int[] dist = new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		dist[0] = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()){
		    int sNode = q.remove();
		    int sDist = dist[sNode];
		    
		    for(Pair p : adj.get(sNode)){
		        int i = p.node;
		        int oDist = p.dist;
		        
		        int nDist = sDist + oDist;
		        if(nDist<dist[i]){
		            dist[i] = nDist;
		            q.add(i);
		        }
		        
		    }
		    
		}
		
		for(int i=0;i<n;i++){
		    if(dist[i]==Integer.MAX_VALUE)dist[i] = -1;
		}
		
		return dist;
		
	}
}