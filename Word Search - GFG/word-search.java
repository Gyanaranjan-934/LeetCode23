//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    private boolean isPossible(int srow,int scol,int ind,String word,char[][] board,int[][] visited){
        if(ind==word.length())return true;
        
        
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow = srow + drow[i];
            int ncol = scol + dcol[i];
            
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && board[nrow][ncol]==word.charAt(ind) && visited[nrow][ncol]!=1){
                visited[nrow][ncol]=1;
                if(isPossible(nrow,ncol,ind+1,word,board,visited))return true;
                else visited[nrow][ncol]=0;
            }
        }
        return false;
    }
    public boolean isWordExist(char[][] board, String word)
    {
        int[][] visited = new int[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    visited[i][j] = 1;
                    boolean res = isPossible(i,j,1,word,board,visited);
                    if(res)return true;
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }
}