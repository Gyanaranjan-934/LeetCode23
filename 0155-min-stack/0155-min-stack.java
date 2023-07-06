class Node{
    int val;
    int minVal;
    Node next;
    Node(int a,int b){
        val = a;
        minVal=b;
        next=null;
    }
}
class MinStack {
    Node head ;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head==null){
            Node temp = new Node(val,val);
            head = temp;
        }else{
            Node temp = new Node(val,Math.min(head.minVal,val));
            temp.next=head;
            head=temp;
        }
    }
    
    public void pop() {
        if(head!=null)
            head=head.next;
    }
    
    public int top() {
        return head.val;    
    }
    
    public int getMin() {
        return head.minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */