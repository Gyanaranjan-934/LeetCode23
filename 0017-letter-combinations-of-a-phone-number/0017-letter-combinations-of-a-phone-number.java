class Solution {
    private void helper(int ind,String num,HashMap<Integer,String> map,String temp,List<String> res){

        if(ind==num.length()){
            if(temp.length()==num.length())
                res.add(temp);
            return ;
        }

        int dig = num.charAt(ind)-'0';
        String digStr = map.get(dig);
        for(int i=0;i<digStr.length();i++){
            helper(ind+1,num,map,temp+digStr.charAt(i),res);
        }

    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> keyMap = new HashMap<>();
        keyMap.put(2,"abc");
        keyMap.put(3,"def");
        keyMap.put(4,"ghi");
        keyMap.put(5,"jkl");
        keyMap.put(6,"mno");
        keyMap.put(7,"pqrs");
        keyMap.put(8,"tuv");
        keyMap.put(9,"wxyz");


        List<String> res = new ArrayList<>();
        if(digits.length()==0)return res;
        helper(0,digits,keyMap,"",res);
        return res;
    }
}