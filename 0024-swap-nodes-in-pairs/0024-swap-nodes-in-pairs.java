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
    public ListNode swapPairs(ListNode head) {
        // if(head==null || head.next==null)return head;

        // ListNode temp = head.next;
        // head.next = swapPairs(head.next.next);
        // temp.next = head;

        // return temp;

        ListNode dnode = new ListNode(-1,head);
        ListNode prev = dnode;
        ListNode curr = head;

        while(curr!=null && curr.next != null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;
            curr = curr.next;
            prev = prev.next.next;
        }
        return dnode.next;
    }
}