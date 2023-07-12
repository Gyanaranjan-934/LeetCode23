class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        // reverse the edges of the graph
        for(int i=0;i<n;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
            }
        }
        // find the terminals
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