class Solution {
    private ArrayList<int[]> merge(ArrayList<int[]> list){
        ArrayList<int[]> res = new ArrayList<int[]>();
        int mini = list.get(0)[0];
        int maxi = list.get(0)[1];

        for(int i=1;i<list.size();i++){
            int newMini = list.get(i)[0];
            int newMaxi = list.get(i)[1];

            if(newMini <= maxi){
                maxi = Math.max(maxi,newMaxi);
            }else{
                res.add(new int[]{mini,maxi});
                mini = newMini;
                maxi = newMaxi;
            }
        }
        res.add(new int[]{mini,maxi});
        return res;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] row:intervals)
            list.add(row);

        list.add(newInterval);
        Collections.sort(list,(x,y)->x[0]-y[0]);

        ArrayList<int[]> tempRes = merge(list);
        int[][] res = new int[tempRes.size()][2];
        for(int i=0;i<res.length;i++){
            res[i][0]=tempRes.get(i)[0];
            res[i][1]=tempRes.get(i)[1];
        }

        return res;
    }
}