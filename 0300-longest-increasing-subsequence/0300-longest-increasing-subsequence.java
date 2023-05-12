class Solution {
    public int lengthOfLIS(int[] nums) {
        // 1. Recursion + Memoization
        // int n = nums.length;
        // int[][] dp = new int[n][n+1];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        // return recFunc(0,nums,-1,dp);

        // 2. Tabulation
        // int n = nums.length;
        // int[][] dp = new int[n+1][n+1];
        // for(int ind=n-1;ind>=0;ind--){
        //     for(int prev=ind-1;prev>=-1;prev--){
        //         int pick = 0;
        //         if(prev == -1 || nums[ind]>nums[prev]){
        //             pick = 1 + dp[ind+1][ind+1];
        //         }
        //         int notPick = dp[ind+1][prev+1];
        //         dp[ind][prev+1] = Math.max(pick,notPick);
        //     }
        // }
        // return dp[0][0];

        // Space Optimization
        // int n = nums.length;
        // int[] ahead = new int[n+1];
        // int[] curr = new int[n+1];

        // for(int ind = n-1;ind>=0;ind--){
        //     for(int prev=ind-1;prev>=-1;prev--){
        //         int pick = 0;
        //         if(prev==-1||nums[ind]>nums[prev]){
        //             pick = 1 + ahead[ind+1];
        //         }
        //         int notPick = ahead[prev+1];
        //         curr[prev+1] = Math.max(pick,notPick);
        //     }
        //     ahead = curr;
        // }
        // return ahead[0];
        
        // Space Optimization T=O(N^2) S=O(N)
        // int[] dp = new int[size];
        // Arrays.fill(dp,1);
        // int maxi = Integer.MIN_VALUE;
        // for(int i=1;i<size;i++){
        //     for(int j=0;j<i;j++){
        //         if(nums[j]<nums[i])
        //             dp[i] = Math.max(dp[i],dp[j]+1);
        //     }
        //     maxi = Math.max(dp[i],maxi);
        // }
        // return maxi;
        
        // Using Binary Search T=O(NLogN) S=O(logN)
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int size = nums.length;
        for(int i=1;i<size;i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                // find the index of next greater element
                int ind = binary_search(list,nums[i]);
                list.set(ind,nums[i]);
            }
        }
        
        return list.size();
        
    }
    public int binary_search(ArrayList<Integer> list,int k){
        int lo = 0,hi = list.size()-1;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            if(list.get(mid)==k)return mid;
            else if(list.get(mid) > k)
                hi = mid-1;
            else
                lo = mid+1;
        }
        return lo;
    }
    public int recFunc(int ind,int[] arr,int prev,int[][] dp){
        if(ind==arr.length){
            return 0 ;        
        }
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];
        int notPick = recFunc(ind+1,arr,prev,dp);
        int pick = 0;
        if(prev == -1 || arr[ind]>arr[prev]){
            pick = 1 + recFunc(ind+1,arr,ind,dp);
        }
        return dp[ind][prev+1] = Math.max(pick,notPick);
    }
}