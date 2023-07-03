class Solution {
    // approach 1 (with space)
    private void recFunc1(int[] arr,List<Integer> ds,List<List<Integer>> res,boolean[] visited){
        if(ds.size()==arr.length){
            res.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                ds.add(arr[i]);
                visited[i]=true;
                recFunc1(arr,ds,res,visited);
                visited[i]=false;
                ds.remove(ds.size()-1);
            }
        }

    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void recFunc2(int ind,int[] arr,List<List<Integer>> res){
        if(ind==arr.length){
            List<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            res.add(permutation);
            return;
        }

        for(int i=ind;i<arr.length;i++){
            swap(arr,i,ind);
            recFunc2(ind+1,arr,res);
            swap(arr,i,ind);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // boolean[] visited = new boolean[nums.length];
        // Arrays.fill(visited,false);
        // recFunc1(nums,new ArrayList<Integer>(),res,visited);

        recFunc2(0,nums,res);
        return res;
    }
}