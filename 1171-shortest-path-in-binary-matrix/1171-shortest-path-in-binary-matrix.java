class Pair{
    int dist;
    int row;
    int col;
    Pair(int a,int b,int c){
        this.dist = a;
        this.row = b;
        this.col = c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1)return -1;

        int[][] distance = new int[n][n];
        for(int[] row :distance)
            Arrays.fill(row,Integer.MAX_VALUE);
            
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        
        pq.add(new Pair(1,0,0));
        
        distance[0][0]=1;
        
        int[] drow = {-1,0,1,0,1,1,-1,-1};
        int[] dcol = {0,1,0,-1,1,-1,1,-1};
        
        while(pq.size()!=0){
            int sDist = pq.peek().dist;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.remove();
            
            for(int i=0;i<8;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0 && sDist+1 < distance[nrow][ncol]){
                    pq.add(new Pair(sDist+1,nrow,ncol));
                    distance[nrow][ncol] = sDist+1;
                }
                
            }
            
        }
        
        return distance[n-1][n-1] != Integer.MAX_VALUE ? distance[n-1][n-1] : -1;
    }
}