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
    public int minimumEffortPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] effort = new int[n][m];
        for(int[] row :effort)
            Arrays.fill(row,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        pq.add(new Pair(0,0,0));

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!pq.isEmpty()){
            int sDist = pq.peek().dist;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.remove();

            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newEffort = Math.max(sDist,Math.abs(grid[nrow][ncol]-grid[r][c]));
                    if(newEffort < effort[nrow][ncol]){
                        pq.add(new Pair(newEffort,nrow,ncol));
                        effort[nrow][ncol] = newEffort;
                    }
                }
                    
                
            }
        }
        return effort[n-1][m-1] == Integer.MAX_VALUE ? 0 : effort[n-1][m-1];
    }
}