//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==s){
                res.add(1);
                res.add(i+1);
                return res;
            }
            
            if(map.containsKey(sum-s)){
                res.add(map.get(sum-s)+2);
                res.add(i+1);
                return res;
            }
            
            map.put(sum,map.getOrDefault(sum,i));
        }
        // if(map.containsKey(sum-s)){
        //     res.add(map.get(sum-s)+2);
        //     res.add(n);
        //     return res;
        // }
        res.add(-1);
        return res;
    }
}