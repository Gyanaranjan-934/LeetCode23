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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    
    
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] row :edges){
            int u = row[0];
            int v = row[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        
        // Initialize the distance array with infinite distance for all nodes
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        // set the distance of src node from src node to 0
        dist[src] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(!q.isEmpty()){
            int sNode = q.remove();
            int sDist = dist[sNode];
            for(int i : adj.get(sNode)){
                int nDist = sDist+1;
                if(nDist<dist[i]){
                    q.add(i);
                    dist[i] = nDist;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE)dist[i]=-1;
        }
        
        return dist;
        
    }
    
    
    
}