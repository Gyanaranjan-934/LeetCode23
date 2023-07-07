class Pair{
    int stock;
    int day;
    Pair(int a,int b){
        this.stock = a;
        this.day = b;
    }
}
class StockSpanner {
    Stack<Pair> stk;
    int day = 0;
    public StockSpanner() {
        stk = new Stack<Pair>();
        day = 0;
    }
    
    public int next(int price) {
        day++;
        int cnt = 1;
        while(!stk.isEmpty() && stk.peek().stock<=price){
            // System.out.print(stk.peek()+" ");
            stk.pop();
            cnt++;
        }
        if(stk.isEmpty()) cnt=day;
        else cnt = day-stk.peek().day;
        stk.push(new Pair(price,day));
        return cnt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */