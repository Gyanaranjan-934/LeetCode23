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
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> stk = new Stack<>();
        String res = "";
        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
                stk.push(ch+"");
            else{
                String op1 = stk.pop();
                String op2 = stk.pop();
                stk.push("("+op2+ch+op1+")");
            }
        }
        return stk.pop();
    }
}
