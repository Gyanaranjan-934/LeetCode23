//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] dfsStack = new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfsStack[i]=1;
                if(dfs(i,adj,visited,dfsStack))return true;
                dfsStack[i]=0;
            }
        }
        return false;
    }
    public boolean dfs(int ind,ArrayList<ArrayList<Integer>> adj,int[] visited,int[] dfsStack){
        visited[ind]=1;
        for(int i:adj.get(ind)){
            if(visited[i]==0){
                dfsStack[i]=1;
                boolean res = dfs(i,adj,visited,dfsStack);
                if(res==true)return true;
                dfsStack[i]=0;
            }else if(dfsStack[i]==1)return true;
        }
        return false;
    }
}