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
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    String s;
    int freq;
    Pair(String str,int a){
        this.s = str;
        this.freq = a;
    }
}
class Solution{
    private boolean isValid(String s1,String s2){
        int i=0,j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else return false;
        }
        return true;
    }
    ArrayList<String> CamelCase(int N,String[] Dictionary,String patt){
        ArrayList<String> res = new ArrayList<>();
        
        HashMap<String,Pair> map = new HashMap<>();
        for(String str : Dictionary){
            String temp = "";
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>=65 && str.charAt(i)<=90)
                    temp += Character.toString(str.charAt(i));
            }
            if(map.containsKey(str)){
                int oldFreq = map.get(str).freq;
                map.put(str,new Pair(temp,oldFreq+1));
            }else{
                map.put(str,new Pair(temp,1));
            }
        }
        for(Map.Entry<String,Pair> entry : map.entrySet()){
            String str = entry.getValue().s;
            String string  = entry.getKey();
            if(str.length()>=patt.length() && isValid(str,patt))
            {
                int k = entry.getValue().freq;
                while(k!=0){
                    res.add(string);
                    k--;
                }
            }
        }
        
        Collections.sort(res);
        if(res.isEmpty()){
            res.add("-1");
        }
        
        return res;
    }
}