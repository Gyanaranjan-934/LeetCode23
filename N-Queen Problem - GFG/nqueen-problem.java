//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    private static boolean isSafe(int row, int col, int[][] list) {
        int drow = row;
        int dcol = col;

        // Check top-left diagonal
        while (row >= 0 && col >= 0) {
            if (list[row][col] == 1) return false;
            row--;
            col--;
        }

        // Check top row
        row = drow;
        col = dcol;
        while (row >= 0) {
            if (list[row][col] == 1) return false;
            row--;
        }

        // Check top-right diagonal
        row = drow;
        col = dcol;
        while (row >= 0 && col < list.length) {
            if (list[row][col] == 1) return false;
            row--;
            col++;
        }

        return true;
    }

    private static void recFunc(int ind, int n, int[][] list, ArrayList<ArrayList<Integer>> res) {
        if (ind == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int[] nrow : list){
                for(int i=0;i<nrow.length;i++){
                    if(nrow[i]==1)temp.add(i+1);
                }
            }
            res.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(ind, i, list)) {
                list[ind][i] = 1;
                recFunc(ind + 1, n, list, res);
                list[ind][i] = 0;
            }
        }
    }
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[][] list = new int[n][n];
        recFunc(0, n, list, res);
        return res;
    }
}