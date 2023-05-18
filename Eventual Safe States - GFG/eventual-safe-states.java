//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> graph) {

        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.size();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            for(int j:graph.get(i)){
                adj.get(j).add(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[n];

        for(int i=0;i<adj.size();i++){
            for(int j : adj.get(i))
                indeg[j]++;
        }

        for(int i=0;i<n;i++){
            if(indeg[i]==0)q.add(i);
        }

        while(!q.isEmpty()){
            int k = q.remove();
            list.add(k);
            for(int i:adj.get(k)){
                indeg[i]--;
                if(indeg[i]==0)
                    q.add(i);
            }

        }

        Collections.sort(list);

        return list;
    }
}
