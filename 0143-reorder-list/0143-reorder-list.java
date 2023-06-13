/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        // finding mid elem
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // reversing the second half
        ListNode head1 = head;
        ListNode newNode = reverse(slow.next);
        slow.next=null;
        

        // iterate both and merge them
        ListNode curr = head;
        ListNode dummy = newNode;
        while(head!=null && dummy!=null){
            ListNode temp = curr.next;
            //link element of 1st half to that of second half
            curr.next=dummy;
            //pointer to store next element of dummy(2nd half list)
            ListNode temp2=dummy.next;
            //link the rest of the first half list
            dummy.next=temp;
            //increment curr and dummy pointer to do the same thing again and again util we reach end of the any one list or both list
            curr=temp;
            dummy=temp2;
        }
        // head=res;
    }   
}