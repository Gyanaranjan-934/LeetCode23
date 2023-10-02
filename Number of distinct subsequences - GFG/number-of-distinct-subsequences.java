//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    int distinctSubsequences(String S) {
        // HashSet<String> set = new HashSet<String>();
        // int 
        // int res = recFunc(s.length()-1,s,"",set);
        
        // return res;
        int mo=1000000007;
        int n=S.length();
        int dp[]=new int[n+1];
        dp[0]=1;
        HashMap<Character ,Integer> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            
            dp[i]=(2*dp[i-1])%mo;
            char ch=S.charAt(i-1);
            if(map.containsKey(ch)){
                int j=map.get(ch);
                dp[i]=(dp[i]-dp[j-1]+mo)%mo;
            }
            map.put(ch,i);
        }
        return dp[n];
    }
    int recFunc(int ind,String s,String curr,HashSet<String> set){
        if(ind<0){
            if(set.contains(curr))return 0;
            set.add(curr);
            return 1;
        }
        
        int pick = recFunc(ind-1,s,Character.toString(s.charAt(ind)) + curr,set);
        int notPick = recFunc(ind-1,s,curr,set);
        
        return pick+notPick;
        
    }
}