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
// } Driver Code Ends



class Pair{
    int val;
    int parent;
    Pair(int a,int b){
        this.val = a;
        this.parent = b;
    }
}

class Solution {
    private boolean bfs(int src,Queue<Pair> q,HashSet<Integer> visited,ArrayList<ArrayList<Integer>> adj){
        // Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            visited.add(p.val);
            for(int i: adj.get(p.val)){
                if(visited.contains(i)){
                    if(i!=p.parent)return true;
                }
                else q.add(new Pair(i,p.val));
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        
        
        for(int i=0;i<V;i++){
            if(!visited.contains(i)){
                // System.out.println(q.isEmpty());
                q.clear();
                boolean res = bfs(i,q,visited,adj);
                if(res==true)return true;
            }
        }
        return false;
        
    }
}