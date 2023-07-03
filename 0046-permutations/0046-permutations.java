class Solution {
    private void recFunc(int[] arr,List<Integer> ds,List<List<Integer>> res,boolean[] visited){
        if(ds.size()==arr.length){
            res.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                ds.add(arr[i]);
                visited[i]=true;
                recFunc(arr,ds,res,visited);
                visited[i]=false;
                ds.remove(ds.size()-1);
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited,false);
        recFunc(nums,new ArrayList<Integer>(),res,visited);
        return res;
    }
}