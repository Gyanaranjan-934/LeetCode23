class Solution {
    private int firstDig(int num){
        while(num>10)num=num/10;
        return num;
    }
    private boolean isCoprime(int a,int b){
        for(int i=9;i>1;i--){
            if(a%i== 0 && b%i==0)return false;
        }
        return true;
    }
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                String s = Integer.toString(nums[i]);
                int a = s.charAt(0)-'0';
                int b = nums[j]%10;
                
                if(isCoprime(a,b))
                    count++;
            }
        }
        return count;
    }
}