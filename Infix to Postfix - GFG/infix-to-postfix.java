//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int prec(Character ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            
        }
        return -1;
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        String res = "";
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                res += ch;
            }
            else if(ch=='('){
                stk.push(ch);
            }else if(ch==')'){
                while(!stk.isEmpty() && stk.peek()!='('){
                    res += stk.pop();
                }
                stk.pop();
            }else{
                while(!stk.isEmpty() && prec(stk.peek())>=prec(ch))
                    res += stk.pop();
                
                stk.push(ch);
            }
        }
        while(!stk.isEmpty()){
            if(stk.peek()=='(')return "Invalid";
            res += stk.pop();
        }
        return res;
    }
} 