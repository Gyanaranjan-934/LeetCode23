class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] nTime = new int[n];
        int[] yTime = new int[n];
        char[] arr = customers.toCharArray();
        if(arr[0]=='N')nTime[0]=1;
        if(arr[n-1]=='Y')yTime[n-1] = 1;
        
        for(int i=1;i<n;i++){
            if(arr[i]=='Y') nTime[i] = nTime[i-1];
            else nTime[i] = nTime[i-1]+1;
        }

        for(int i=n-2;i>=0;i--){
            if(arr[i]=='N'){
                yTime[i] = yTime[i+1];
            }else{
                yTime[i] = yTime[i+1]+1;
            }
        }

        // for(int i : nTime){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        // for(int i : yTime){
        //     System.out.print(i+" ");
        // }

        int minPen = Integer.MAX_VALUE;
        int minInd = n-1;
        for(int i=0;i<=n;i++){
            int totPen = 0;
            if(i>0)totPen += nTime[i-1];
            if(i<n)totPen += yTime[i];

            if(totPen<minPen){
                minPen = totPen;
                minInd = i;
            }
        }
        return minInd;
    }
}