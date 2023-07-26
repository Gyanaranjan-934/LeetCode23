class Solution {
    private double isPossible(double speed,int[] dist,double hour){
        double totTime = 0.0;
        for(int i=0;i<dist.length-1;i++){
            totTime += Math.ceil(dist[i]/speed);
        }
        totTime += dist[dist.length-1]/speed;
        return totTime;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int)1e9;
        
        // high++;
        int mini = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;
            double totTime = isPossible(mid,dist,hour);
            // System.out.println(mid+"->"+totTime);
            if(totTime<=hour){
                mini = Math.min(mid,mini);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return mini==Integer.MAX_VALUE ? -1 : mini;
    }
}