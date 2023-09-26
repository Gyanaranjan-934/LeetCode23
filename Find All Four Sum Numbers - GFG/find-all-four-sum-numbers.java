//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        int n = arr.length;
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Set<ArrayList<Integer>> set = new LinkedHashSet<ArrayList<Integer>>();
        
        Arrays.sort(arr);
        
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                long tar = (long)k-(arr[i]+arr[j]);
                int low = j+1;
                int high = n-1;
                while(low<high){
                    long sum = (long)(arr[low]+arr[high]);
                    if(sum==tar){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[low]);
                        list.add(arr[high]);
                        set.add(list);
                        // while(low<high && arr[low]==arr[low+1])        //skip duplicates
                        //     low++;
                        // while(low<high && arr[high]==arr[high-1])      //skip duplicates
                        //     high--;
                        low++;
                        high--;
                    }
                    else if(sum<tar){
                        low++;
                    }
                    else high--;
                }
                // while(j<n-3 && arr[j]==arr[j+1])  //skip duplicates
                //     j++;
            }
            // while(i<n-4 && arr[i]==arr[i+1])      //skip duplicates
            //     i++;
        }
        res.addAll(set);
        // Collections.sort(res,(x,y)->x.get(0)-y.get(0));
        return res;
    }
    
}