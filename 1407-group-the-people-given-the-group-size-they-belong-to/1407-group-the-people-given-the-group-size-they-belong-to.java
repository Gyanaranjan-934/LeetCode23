class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                List<Integer> list = new ArrayList<>();
                map.put(arr[i],list);
            }
            map.get(arr[i]).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int i=0;
            List<Integer> list = entry.getValue();
            int grpSize = entry.getKey();
            List<Integer> temp = new ArrayList<>();
            while(i<list.size()){
                temp.add(list.get(i));
                if(temp.size()==grpSize){
                    res.add(new ArrayList<Integer>(temp));
                    temp.clear();
                }
                i++;
            }
        }
        return res;
    }
}