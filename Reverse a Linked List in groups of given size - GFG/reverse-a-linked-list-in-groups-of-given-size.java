//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    private static Node findKthNode(Node ptr,int k){
        while(ptr!=null && k!=0){
            ptr = ptr.next;
            k--;
        } 
        return ptr;
    } 
    private static Node reverse(Node head){
        if(head==null || head.next==null)return head;
        Node prev = null;
        Node h2 = reverse(head.next);
        head.next.next = head;
        head.next = prev;
        return h2;
    }
    public static Node reverse(Node head, int k)
    {
        if(head==null || head.next==null)return head;
        Node newHead = new Node(-1);
        Node headPtr = newHead;
        Node ptr = head;
        Node nextNode = null;
        while(ptr!=null){
            Node kthNode = findKthNode(ptr,k-1);
            if(kthNode != null){
                nextNode = kthNode.next;
                kthNode.next = null;
                
                Node reverseNode = reverse(ptr);
                headPtr.next = reverseNode;

                headPtr = ptr;

                ptr = nextNode;
            }
            else{
                headPtr.next = reverse(ptr);
                break;
            }
        }
        return newHead.next;
    }
}

