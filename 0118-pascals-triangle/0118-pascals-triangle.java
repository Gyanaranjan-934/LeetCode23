class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        res.get(0).add(1);
        for(int i=1;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=1;j<res.get(i-1).size();j++){
                list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}