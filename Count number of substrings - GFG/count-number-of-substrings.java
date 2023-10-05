//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private long cntMinSubstrings(String s,int k){
        // HashMap<Character,Integer> map = new HashMap<>();
        int[] arr = new int[26];
        int start = 0;
        long cnt = 0;
        int distCnt = 0;
        char[] strArr =  s.toCharArray();
        for(int i=0;i<strArr.length;i++){
            arr[strArr[i]-'a']++;
            if(arr[strArr[i]-'a']==1)distCnt++;
            // while(map.size()>k){
            //     map.put(strArr[start],map.get(strArr[start])-1);
            //     if(map.get(strArr[start])==0)map.remove(strArr[start]);
            //     start++;
            // }
            while(distCnt>k){
                arr[strArr[start]-'a']--;
                if(arr[strArr[start]-'a']==0)distCnt--;
                start++;
            }
            cnt += (long)(i-start)+1;
        }
        return cnt;
    }
    long substrCount (String S, int k) {
        // count no. of substring atleast k diff chars-count np. of substrings atleast k-1 diff chars
        return cntMinSubstrings(S,k)-cntMinSubstrings(S,k-1);
    }
}