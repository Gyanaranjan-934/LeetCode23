class Solution {
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void recFunc(int ind,int[] arr,List<List<Integer>> res){
        if(ind==arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i:arr)list.add(i);
            res.add(list);
        }
        for(int i=ind;i<arr.length;i++){
            swap(arr,i,ind);
            recFunc(ind+1,arr,res);
            swap(arr,i,ind);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recFunc(0,nums,res);
        return res;
    }
}