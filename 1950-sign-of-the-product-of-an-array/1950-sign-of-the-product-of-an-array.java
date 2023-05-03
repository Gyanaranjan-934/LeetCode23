class Solution {
    public int arraySign(int[] nums) {
        int cntPos = 0;
        int cntNeg = 0;
        for(int i : nums){
            if(i==0)return 0;
            if(i<0)cntNeg++;
            if(i>0)cntPos++;
        }
        if(cntNeg % 2 == 0)return 1;
        else if (cntNeg >0)return -1;
        return 1;
    }
}