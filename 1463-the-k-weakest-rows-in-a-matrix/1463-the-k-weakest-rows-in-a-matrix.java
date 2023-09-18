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
        Collections.sort(arr,(x,y)->{
            if(x.b==y.b)return x.a-y.a;
            return x.b-y.b;
        });
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = arr.get(i).a;
        }
        return res;
    }
}