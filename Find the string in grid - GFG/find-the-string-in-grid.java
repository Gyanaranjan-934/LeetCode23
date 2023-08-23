//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Pair{
    int row;
    int col;
    Pair(int a,int b){
        this.row = a;
        this.col = b;
    }
}

class Solution
{
    private boolean recFunc(int row,int col,String word,int k,int strInd,int[] drow,int[] dcol,char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        if(strInd==word.length()){
            // System.out.println("Found");
            return true;
        }
        
        if(row<0 || row>=n || col<0 || col>=m){
            // System.out.println("Not found");
            return false;
        }
        
        
        if(word.charAt(strInd)==grid[row][col]){
            // System.out.println("find at "+row+" "+col+" going to "+(row+drow[k])+" "+(col+dcol[k]));
            return recFunc(row+drow[k],col+dcol[k],word,k,strInd+1,drow,dcol,grid);
        }else
            return false;
    }
    public int[][] searchWord(char[][] grid, String word)
    {
        int[] drow = {0,-1,0,+1,-1,-1,+1,+1};
        int[] dcol = {-1,0,+1,0,-1,+1,-1,+1};
        int n = grid.length;
        int m = grid[0].length;
        ArrayList<Pair> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==grid[i][j]){
                    
                    for(int k=0;k<8;k++){
                        // System.out.println(i+" "+j+" "+k);
                        boolean temp = recFunc(i,j,word,k,0,drow,dcol,grid);
                        if(temp){
                            // System.out.println("row: "+i+" col: "+j);
                            res.add(new Pair(i,j));
                            break;
                        }
                    }    
                }
            }
        }
        Collections.sort(res,(x,y)->x.row-y.row);
        int[][] result = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            result[i][0] = res.get(i).row;
            result[i][1] = res.get(i).col;
        }
        return result;
    }
}