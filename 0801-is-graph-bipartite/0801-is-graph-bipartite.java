class Solution {
    private boolean bfs(int src,int[] color,int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0; 
        while(!q.isEmpty()){
            int k = q.poll();
            for(int i : graph[k]){
                if(color[i]==-1){
                    q.add(i);
                    color[i] = 1-color[k];
                }else if(color[i]==color[k]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(i,color,graph))return false;
            }
        }
        return true;
    }
}