class Solution {
    public int findCircleNum(int[][] adj) {
        boolean[] visited = new boolean[adj.length];
        Arrays.fill(visited,false);
        int cnt = 0;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                cnt++;
                bfs(adj,visited,i);
            }
        }
        
        return cnt;
    }
    public void bfs(int[][] adj,boolean[] visited,int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s]=true;
        while(!q.isEmpty()){
            int temp = q.remove();
            for(int i=0;i<adj[temp].length;i++){
                int k = adj[temp][i];
                if(k==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}