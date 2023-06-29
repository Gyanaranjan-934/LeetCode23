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
    public boolean isPalindrome(ListNode head) {
        if(head == null)return true;
        else if(head.next==null)return true;
        ListNode low1 = head;
        ListNode high = head;
        ListNode low = null;
        while(high!=null && high.next!=null)
        {
            low = low1;
            low1 = low1.next;
            high = high.next.next;
        }
        ListNode prev = low;
        ListNode curr = low.next;
        while(curr!=null)
        {
            ListNode nxt = curr.next;
            curr.next = prev;
            curr.next = prev;
            prev=curr;
            curr=nxt;
        }
        ListNode start = head;
        ListNode end = prev;
        while(start!=end)
        {
            if(start.val!=end.val)return false;
            if(end.next==start)break;
            start = start.next;
            end = end.next;
        }
        return true;
    }
}