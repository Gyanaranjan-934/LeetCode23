class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                List<Integer> list = new ArrayList<>();
                map.put(arr[i],list);
            }
            map.get(arr[i]).add(i);
            if(map.get(arr[i]).size()==arr[i]){
                res.add(new ArrayList<Integer>(map.get(arr[i])));
                map.get(arr[i]).clear();
            }
        }
        return res;
    }
}