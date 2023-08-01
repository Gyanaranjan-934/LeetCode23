class Solution {
    private void helper(int ind,int[] arr,List<List<Integer>> res,int k,ArrayList<Integer> ds){
        if(k==0){
            res.add(new ArrayList<Integer>(ds));
            return ;
        }
        for(int i=ind;i<arr.length;i++){
            ds.add(arr[i]);
            helper(i+1,arr,res,k-1,ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] arr = new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        helper(0,arr,res,k,new ArrayList<Integer>());
        return res;
    }
}