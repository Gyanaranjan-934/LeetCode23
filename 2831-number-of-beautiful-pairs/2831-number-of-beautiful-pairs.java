class Solution {
    private int firstDig(int num){
        while(num >= 10) num = num / 10;
        return num;
    }

    private boolean isCoprime(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a == 1;
    }

    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int a = firstDig(nums[i]);
                int b = nums[j] % 10;
                
                if(isCoprime(a, b))
                    count++;
            }
        }
        return count;
    }

}