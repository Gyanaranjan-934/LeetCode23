class Solution {
    private void recFunc(int countOpen,int countClose,String temp,List<String> res){
        if(countOpen==0 && countClose==0){
            res.add(temp);
            return;
        }
        if(countOpen>=0)
            recFunc(countOpen-1,countClose,temp+"(",res);
        
        if(countClose>countOpen)
            recFunc(countOpen,countClose-1,temp+")",res);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recFunc(n,n,"",res);
        return res;
    }
    
}