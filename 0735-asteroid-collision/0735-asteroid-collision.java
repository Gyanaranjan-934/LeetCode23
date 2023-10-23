class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for(int curr:arr){
            if(curr>0)s.push(curr);
            else{
                while(!s.isEmpty() && s.peek()>0 && Math.abs(curr)>s.peek())s.pop();
                if(s.isEmpty() || s.peek()<0)s.push(curr);
                if(s.peek()+curr==0)s.pop();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!s.isEmpty())list.add(s.pop());
        int[] res = new int[list.size()];
        for(int i=res.length-1;i>=0;i--){
            res[res.length-1-i]=list.get(i);
        }
        return res;
    }
}