class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new HashSet<Integer>());
        int[] deg = new int[n];
        for(int[] row : roads){
            adj.get(row[0]).add(row[1]);
            adj.get(row[1]).add(row[0]);
            deg[row[0]]++;
            deg[row[1]]++;
        }
        int maxi = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int sum = deg[i]+deg[j];
                if(adj.get(i).contains(j))sum-=1;
                maxi = Math.max(maxi,sum);
            }
        }
        return maxi;
    }
}