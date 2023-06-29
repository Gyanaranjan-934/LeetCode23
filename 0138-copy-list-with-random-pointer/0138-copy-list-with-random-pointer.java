/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node ptr = head;
        // set next pointers
        while(ptr!=null){
            Node temp = ptr.next;
            ptr.next = new Node(ptr.val);
            ptr.next.next = temp;
            ptr = temp;
        }
        System.out.println("Duplicates inserted");
        ptr = head;
        // set random pointers
        while(ptr!=null){
            if(ptr.random == null)ptr.next.random=null;
            else ptr.next.random = ptr.random.next;
            ptr = ptr.next.next;
        }
        System.out.println("Random pointers added");
        ptr = head;
        Node duplicate = head.next;
        while(ptr.next!=null){
            Node copied = ptr.next;
            ptr.next = copied.next;
            if(ptr.next==null){
                copied.next=null;
                break;
            }
            else copied.next = ptr.next.next;
            ptr = ptr.next;
        }
        System.out.println("Original removed");
        return duplicate;
    }
}