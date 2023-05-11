class Solution {
    public int maxProfit(int k, int[] arr) {
        // 1. Recursion + Memoization
        // int[][][] dp = new int[arr.length+1][2][3];
        // for(int[][] mat : dp){
        //     for(int[] row : mat){
        //         Arrays.fill(row,-1);
        //     }
        // }
        // return recFunc(0,arr,1,2,dp);

        // 2. Tabulation
        // int n = arr.length;
        // int[][][] dp = new int[n+1][2][3];

        // for(int i=n-1;i>=0;i--){
        //     for(int j=1;j>=0;j--){
        //         for(int k=2;k>=1;k--){
        //             if(j==1){
        //                 dp[i][j][k] = Math.max(-arr[i]+dp[i+1][0][k],dp[i+1][1][k]);
        //             }else{
        //                 dp[i][j][k] = Math.max(arr[i]+dp[i+1][1][k-1],dp[i+1][0][k]);
        //             }
        //         }
        //     }
        // }

        // return dp[0][1][2];

        // 3. Space Optimization
        // int n = arr.length;
        
        // int[][] after = new int[2][3];
        // int[][] curr = new int[2][3];

        // for(int i=n-1;i>=0;i--){
        //     for(int j=1;j>=0;j--){
        //         for(int k=2;k>=1;k--){
        //             if(j==1){
        //                 curr[j][k] = Math.max(-arr[i]+after[0][k],after[1][k]);
        //             }else{
        //                 curr[j][k] = Math.max(arr[i]+after[1][k-1],after[0][k]);
        //             }
        //         }
        //     }
        //     after = (int[][])(curr.clone());
        // }

        // return after[1][2];

        // Space Optimization 2
        int n = arr.length;
        int[] after = new int[2*k+1];
        int[] curr  = new int[2*k+1];

        for(int i=n-1;i>=0;i--){
            for(int j=2*k-1;j>=0;j--){
                if(j%2==0){
                    curr[j] = Math.max(-arr[i]+after[j+1],after[j]);
                }else{
                    curr[j] = Math.max(arr[i]+after[j+1],after[j]);
                }
            }
            after = (int[])(curr.clone());
        }

        return after[0];
    }
    public int recFunc(int ind,int[] arr,int buy,int sells_left,int[][][] dp){
        if(sells_left==0 || ind==arr.length)return 0;
        
        if(dp[ind][buy][sells_left]!=-1)return dp[ind][buy][sells_left];

        if(buy==1){
            return dp[ind][buy][sells_left] = Math.max(-arr[ind]+recFunc(ind+1,arr,0,sells_left,dp),recFunc(ind+1,arr,1,sells_left,dp));
        }else{
            return dp[ind][buy][sells_left] = Math.max(arr[ind]+recFunc(ind+1,arr,1,sells_left-1,dp),recFunc(ind+1,arr,0,sells_left,dp));
        }

    }
}