class KthLargest {
    ArrayList<Integer> list ;
    int k;
    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        list = new ArrayList<>();
        for(int i:nums)list.add(i);
        this.k = k;
    }
    
    public int add(int val) {
        int ind = findInd(list,val);
        list.add(ind,val);
        return list.get(list.size()-this.k);
    }
    private int findInd(ArrayList<Integer> list,int val){
        int low = 0;
        int high = list.size()-1;
        while(low<=high){
            int mid = (high+low)/2;
            if(list.get(mid)==val){
                return mid;
            }else if(list.get(mid)>val){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low ;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */