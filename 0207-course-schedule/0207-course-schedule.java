class Solution {
    private boolean dfs(int src,ArrayList<ArrayList<Integer>> adj,int[] visited,int[]parent){
       
        visited[src] = 1;
        parent[src] = 1;

        for(int i : adj.get(src)){
            if(visited[i]!=1){
                if(!dfs(i,adj,visited,parent))return false;
            }else if(parent[i]==1)return false;
        }
        parent[src] = 0;
        return true;
    }
    public boolean canFinish(int n, int[][] preq) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<Integer>());
        for(int[] row : preq){
            adj.get(row[1]).add(row[0]);
        }
        

        int[] visited = new int[n];
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0)
                if(!dfs(i,adj,visited,parent))return false;
        }
        return true;
    }
}