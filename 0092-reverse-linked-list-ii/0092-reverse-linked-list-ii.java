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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right)return head;
        ListNode dnode = new ListNode(-1);
        dnode.next = head;
        ListNode prev = dnode;
        for(int i=0;i<left-1;i++)prev=prev.next;
        ListNode curr = prev.next;
        for(int i=0;i<right-left;i++){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dnode.next;
    }
}