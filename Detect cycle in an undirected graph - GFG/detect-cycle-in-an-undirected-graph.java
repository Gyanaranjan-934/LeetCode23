//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Endshttps://practice.geeksforgeeks.org/contest/job-a-thon-20-hiring-challenge

// class Solution {
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         int[] parent = new int[V];
//         Arrays.fill(parent,-1);
//         boolean[] visited = new boolean[V];
//         Arrays.fill(visited,false);
//         for(int i=0;i<V;i++){
//             if(!visited[i]){
//                 int k = bfs(i,visited,parent,adj);
//                 if(k==1)return true;
//             }
//         }
//         return false;
//     }
//     public int bfs(int ind,boolean[] visited,int[] parent,ArrayList<ArrayList<Integer>> adj){
//         Queue<Integer> q = new LinkedList<>();
//         q.add(ind);
//         visited[ind]=true;
//         while(!q.isEmpty()){
//             int k = q.remove();
//             int pt = parent[k];
//             for(int i :adj.get(k)){
//                 if(!visited[i]){
//                     visited[i]=true;
//                     parent[i]=k;                
//                     q.add(i);
//                 }
//                 else if(i!=pt)return 1;
//             }
            
//         }
//         return 0;
//     }
// }
class Solution {
    // Function to detect cycle in an undirected graph.
    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> 
    adj) {
        vis[node] = 1; 
        // go to all adjacent nodes
        for(int adjacentNode: adj.get(node)) {
            if(vis[adjacentNode]==0) {
                if(dfs(adjacentNode, node, vis, adj) == true) 
                    return true; 
            }
            // if adjacent node is visited and is not its own parent node
            else if(adjacentNode != parent) return true; 
        }
        return false; 
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       int vis[] = new int[V]; 
       for(int i = 0;i<V;i++) {
           if(vis[i] == 0) {
               if(dfs(i, -1, vis, adj) == true) return true; 
           }
       }
       return false; 
    }
}

