//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int tasks[][],int n){
        // 1. Recursion
        // return recFunc(n-1,tasks,3);
        
        // 2. Memoization
        // int[][] dp = new int[n][4];
        // for(int[] row: dp)
        //     Arrays.fill(row,-1);
        // return memFunc(n-1,tasks,3,dp);
        
        // 3. Tabulation
        int[][] dp = new int[n][4];
        
        dp[0][0] = Math.max(tasks[0][1],tasks[0][2]);
        dp[0][1] = Math.max(tasks[0][0],tasks[0][2]);
        dp[0][2] = Math.max(tasks[0][1],tasks[0][0]);
        dp[0][3] = Math.max(tasks[0][0],Math.max(tasks[0][1],tasks[0][2]));
        
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = tasks[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }

        return dp[n - 1][3];
        
    }
    
    public int recFunc(int ind,int[][] tasks,int task){
        if(ind==0){
            int maxi = 0;
            for(int i=0;i<tasks[0].length;i++){
                if(i!=task){
                    maxi = Math.max(tasks[0][i],maxi);
                }
            }
            return maxi;
        }
        
        int maxi = 0;
        for(int i=0;i<3;i++){
            int points = 0;
            if(i!=task){
                points = tasks[ind][i] + recFunc(ind-1,tasks,i);
            }
            maxi = Math.max(maxi,points);
        }
        return maxi;
        
        
    }
    public int memFunc(int ind,int[][] tasks,int task,int[][] dp){
        if(ind==0){
            int maxi = 0;
            for(int i=0;i<tasks[0].length;i++){
                if(i!=task){
                    maxi = Math.max(tasks[0][i],maxi);
                }
            }
            return maxi;
        }
        
        if(dp[ind][task]!= -1)return dp[ind][task];
        int maxi = 0;
        for(int i=0;i<3;i++){
            int points = 0;
            if(i!=task){
                points = tasks[ind][i] + memFunc(ind-1,tasks,i,dp);
            }
            maxi = Math.max(maxi,points);
        }
        return dp[ind][task] = maxi;
        
        
    }
    
}