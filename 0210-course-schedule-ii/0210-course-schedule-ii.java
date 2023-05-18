class Solution {
    public int[] findOrder(int n, int[][] mat) {
        // Solve it by Kahn's algo
        int m = mat.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
            int u = mat[i][1];
            int v = mat[i][0];
            adj.get(u).add(v);
        }

        int[] indeg = new int[n];
        for(int i=0;i<m;i++){
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
        
        if(list.size()<n)return new int[]{};

        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        
        return res;
    }
}