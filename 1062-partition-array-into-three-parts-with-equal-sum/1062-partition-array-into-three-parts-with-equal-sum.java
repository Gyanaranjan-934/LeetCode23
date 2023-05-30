class Solution {
    
    public boolean canThreePartsEqualSum(int[] arr) {
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i]+arr[i-1];
        }
        int first = 0;
        int second = 1;
        int third = arr.length-1;
        while(first<third-1){
            int sum = arr[first];
            second = first+1;
            while(second<third){
                if(arr[second]-arr[first]==sum){
                    break;
                }
                else second++;
            }
            if(second!=third && arr[third]-arr[second]==sum){
                // System.out.println(first+" "+second+" "+third);
                return true;
            }
            first++;
        }
        return false;
    }
}