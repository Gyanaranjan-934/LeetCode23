//{ Driver Code Starts
import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}

class GfG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}

// } Driver Code Ends


class MyStack 
{
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;
    
    //Function to push an integer into the stack.
    void push(int a) 
    {
        // Add your code here
        StackNode node = new StackNode(a);
        // node.data = a;
        StackNode ptr = top;
        if(ptr==null){
            top = node;
        }else{
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = node;
        }
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        // Add your code here
        if(top==null)return -1;
        if(top.next==null){
            int val = top.data;
            top=null;
            return val;
        }
        StackNode curr = top;
        StackNode prev = null;
        
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        int val = curr.data;
        prev.next = null;
        return val;
    }
}
