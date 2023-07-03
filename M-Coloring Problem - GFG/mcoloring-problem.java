//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    
    private boolean isPossible(int color,int ind,ArrayList<ArrayList<Integer>> adj,int[] colorMap){
        for(int i:adj.get(ind)){
            if(colorMap[i]==color)return false;
        }
        return true;
    }
    
    private boolean recFunc(int ind,ArrayList<ArrayList<Integer>> adj, int m, int n,int[] colorMap){
        if(ind==n)return true;
        for(int i=0;i<m;i++){
            int prev = colorMap[ind];
            if(isPossible(i,ind,adj,colorMap)){
                colorMap[ind]=i;
                if(recFunc(ind+1,adj,m,n,colorMap))return true;
                else colorMap[ind]=prev;
            }
        }
        return false;
    }
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<Integer>());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]){
                    adj.get(i).add(j);
                }
            }
        }
        int[] colorMap = new int[n];
        Arrays.fill(colorMap,-1);
        return recFunc(0,adj,m,n,colorMap);
        // return true;
    }
}