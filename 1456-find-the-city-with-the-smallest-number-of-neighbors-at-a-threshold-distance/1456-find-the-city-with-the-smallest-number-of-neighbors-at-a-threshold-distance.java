class Solution {
    public int findTheCity(int n, int[][] edges, int thresh) {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)dist[i][j] = (int)(1e9);
            }
        }

        for(int[] row :edges){
            int u = row[0];
            int v = row[1];
            int c = row[2];
            dist[u][v] = c;
            dist[v][u] = c;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        int res = (int)(1e9);
        int resInd = -1;
        for(int i=0;i<n;i++){
            int cnt =0;
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j]<=thresh)cnt++;
            }
            if(cnt<=res){
                res = cnt;
                resInd = i;
            }
        }

        return resInd;
    }
}