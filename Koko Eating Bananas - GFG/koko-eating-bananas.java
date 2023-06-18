//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int findTime(int[] piles,int speed){
        int cnt = 0;
        for(int i:piles){
            if(i%speed==0)cnt+=i/speed;
            else{
                cnt += (i/speed)+1;
            }
        }
        return cnt;
    }
    public static int Solve(int n, int[] piles, int h) {
        // int n = piles.length;
        Arrays.sort(piles);
        int low = 1;
        int high = piles[n-1];
        
        while(low<high){
            int mid = (low+high)/2;
            int midHr = findTime(piles,mid);
            if(midHr>h)low=mid+1;
            else high=mid;
        }
        return high;
    }
}
        
