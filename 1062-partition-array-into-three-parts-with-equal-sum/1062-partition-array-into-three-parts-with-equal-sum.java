class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum =0;
        for(int i:arr)sum+=i;

        if(sum%3!=0)return false;

        int x = sum/3;
        sum=0;
        int cnt=0;
        for(int i:arr){
            sum+=i;
            if(sum==x){
                cnt++;
                sum=0;
            }
        }
        return cnt>=3;
    }
}