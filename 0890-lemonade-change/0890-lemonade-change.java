class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for(int i:bills){
            if(i==5)fives++;
            else if(i==10){
                fives--;
                tens++;
            }else{
                if(tens>0){
                    tens--;
                    fives--;
                }else
                    fives -=3;
            }
            if(fives<0)return false;
        }
        return true;
    }
}