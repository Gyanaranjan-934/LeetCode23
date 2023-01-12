//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isOperator(char ch){
        if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^')return true;
        return false;
    }
    static String preToInfix(String pref) {
        // code here
        Stack<String> stk = new Stack<>();
        for(int i=pref.length()-1;i>=0;i--){
            char ch = pref.charAt(i);
            if(isOperator(ch)){
                String op1 = stk.pop();
                String op2 = stk.pop();
                stk.push("("+op1+ch+op2+")");
            }else{
                stk.push(ch+"");
            }
        }
        return stk.pop();
    }
}
