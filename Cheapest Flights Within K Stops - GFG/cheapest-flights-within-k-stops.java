//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Tuple{
    int cost;
    int node;
    int stops;
    Tuple(int a,int b,int c){
        this.cost = c;
        this.node = b;
        this.stops = a;
    }
}

class Pair{
    int node;
    int cost;
    Pair(int a,int b){
        this.node = a;
        this.cost = b;
    }
}

class Solution {
    public int CheapestFLight(int n, int[][] flights, int src, int dst, int k) {


        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int[] row :flights){
            int u = row[0];
            int v = row[1];
            int c = row[2];
            adj.get(u).add(new Pair(v,c));
        }

        int[] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        // k++;
        costs[src] = 0;

        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0,src,0));
        
        while(!q.isEmpty()) {
            Tuple it = q.peek(); 
            q.remove(); 
            int stops = it.stops; 
            int node = it.node; 
            int cost = it.cost; 
            
            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue; 
            for(Pair iter: adj.get(node)) {
                int adjNode = iter.node; 
                int edW = iter.cost; 
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < costs[adjNode] && stops <= k) {
                    costs[adjNode] = cost + edW; 
                    q.add(new Tuple(stops + 1, adjNode, cost + edW)); 
                }
            }
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];

    }
}