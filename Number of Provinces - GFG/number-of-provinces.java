//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        int cnt = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                cnt++;
                bfs(adj,visited,i);
            }
        }
        
        return cnt;
        
    }
    
    static void bfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s]=true;
        while(!q.isEmpty()){
            int temp = q.remove();
            for(int i=0;i<adj.get(temp).size();i++){
                int k = adj.get(temp).get(i);
                if(k==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    
};