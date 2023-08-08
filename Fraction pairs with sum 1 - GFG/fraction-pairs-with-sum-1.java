//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    private static int gcd(int a,int b){
        if (b != 0)
            return gcd(b, a % b);
        else
            return a;
            
    }
    public static int countFractions(int n, int[] num, int[] den) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int g = gcd(num[i],den[i]);
            num[i]/=g;
            den[i]/=g;
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            String currNum = num[i]+"/"+den[i];
            String reqNum = (den[i]-num[i])+"/"+den[i];
            if(map.containsKey(reqNum))
                cnt+=map.get(reqNum);
            
            map.put(currNum,map.getOrDefault(currNum,0)+1);
        }
        return cnt;
    }
}
        
