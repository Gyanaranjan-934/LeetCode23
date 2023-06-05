class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(x,y)->{
            if(x[1]==y[1])return x[0]-y[0];
            return x[1]-y[1];
        });
        int mini = intervals[0][0];
        int maxi = intervals[0][1];
        int cnt = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<maxi){
                cnt++;
            }else{
                mini=intervals[i][0];
                maxi=intervals[i][1];
            }
        }
        return cnt;
    }
}