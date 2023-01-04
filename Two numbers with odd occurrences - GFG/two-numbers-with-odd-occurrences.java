//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int arr[], int n)
    {
        // code here
        
        int temp = 0;
        for(int i=0;i<n;i++){
            temp = temp ^ arr[i];
        }
        int k = 0;
        while((temp & 1)!= 1){
            k++;
            temp>>=1;
        }
        int mask = 1;
        mask = mask << k;
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list0 = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if((mask&arr[i])!=0){
                list1.add(arr[i]);
            }else{
                list0.add(arr[i]);
            }
        }
        int[] res = new int[2];
        int a = 0;
        for(int i:list1){
            a = a^i;
        }
        // res[0] = a;
        int b = 0;
        for(int i:list0){
            b = b^i;
        }
        res[0] = Math.max(a,b);
        res[1] = Math.min(a,b);
        return res;
    }
}