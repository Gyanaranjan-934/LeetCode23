class Pair{
    int a,b;
    Pair(int a,int b){
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j:mat[i]){
                sum+=j;
            }
            arr.add(new Pair(i,sum));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->{
            if(x.b==y.b)return y.a-x.a;
            return y.b-x.b;
        });
        ArrayList<Pair> arr1 = new ArrayList<>();
        for(int i=0;i<n;i++){
            pq.add(arr.get(i));
            if(pq.size()>k)pq.remove();
        }
        while(!pq.isEmpty()){
            arr1.add(0,pq.remove());
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = arr1.get(i).a;
        }
        return res;
    }
}