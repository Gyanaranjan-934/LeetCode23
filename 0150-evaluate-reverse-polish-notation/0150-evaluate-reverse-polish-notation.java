class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s : tokens){
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))stk.push(Integer.parseInt(s));
            else{
                if(s.equals("+")){
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(a+b);
                }else if(s.equals("-")){
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(a-b);
                }else if(s.equals("*")){
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(a*b);
                }else if(s.equals("/")){
                    int b = stk.pop();
                    int a = stk.pop();
                    stk.push(a/b);
                }
            }
        }
        return stk.pop();
    }
}