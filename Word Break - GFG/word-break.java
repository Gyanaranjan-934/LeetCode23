//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    private static boolean recFunc(int ind,String str,HashSet<String> set){
        if(ind>=str.length())return true;
        
        for(int i=ind+1;i<=str.length();i++){
            if(set.contains(str.substring(ind,i))){
                if(recFunc(i,str,set))return true;
            }
        }
        return false;
    }
    
    public static int wordBreak(String A, ArrayList<String> B )
    {
        HashSet<String> set = new HashSet<>(B);
        return recFunc(0,A,set)==true ? 1 : 0;
    }
}