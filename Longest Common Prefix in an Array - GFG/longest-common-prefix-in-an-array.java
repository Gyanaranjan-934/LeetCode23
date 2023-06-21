//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //  char[] ans;
    String longestCommonPrefix(String strs[], int n){
        // // code here
        // if(n==1) return arr[0];

        // Map<Integer,String> map=new HashMap<Integer,String>();
        // String ans="",str1,str2;
        // int i=0,j=n-1,minIdx=0;
        // while(i<=j){
        //   str1=arr[i];
        //   str2=arr[j];
        //   ans="";
           
        //   minIdx=Math.min(str2.length(), str1.length());
           
        //   for(int k=0;k<minIdx;k++){
        //       if(str1.charAt(k)!=str2.charAt(k)){break;}
        //       ans+=str1.charAt(k);
        //   }
        //   map.put(ans.length(),ans);
         
        //   i++;
        //   j--;
        // }
       

    //   System.out.println(map.toString());
    //   System.out.println(map.keySet());
    //   System.out.println(Collections.min(map.keySet()));
    //  if((map.get(Collections.min(map.keySet()))).length()==0) return "-1";

    //   return map.isEmpty()  ? 
    //      "-1": map.get(Collections.min(map.keySet())) ;
        for(int i=0;i<strs[0].length();i++)
            {
                char ch = strs[0].charAt(i);
                for(int j=0;j<strs.length;j++)
                {
                    if(strs[j].length()==i || strs[j].charAt(i)!=ch)
                        return strs[j].substring(0,i).length()>0 ? strs[j].substring(0,i) : "-1";
               
                }
            }
        return strs[0];
    }
}