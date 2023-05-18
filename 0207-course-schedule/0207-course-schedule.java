class Solution {
    public boolean canFinish(int n, int[][] mat) {
        // Solve it by Kahn's algo
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<mat.length;i++){
            int u = mat[i][1];
            int v = mat[i][0];
            adj.get(u).add(v);
        }

        int[] indeg = new int[n];
        for(int i=0;i<mat.length;i++){
            indeg[mat[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            if(indeg[i]==0)
                q.add(i);

        while(!q.isEmpty()){
            int k = q.remove();
            list.add(k);
            for(int i : adj.get(k)){
                indeg[i]--;
                if(indeg[i]==0)
                    q.add(i);
            }
        }

        return list.size()==n ? true : false;

    }
}