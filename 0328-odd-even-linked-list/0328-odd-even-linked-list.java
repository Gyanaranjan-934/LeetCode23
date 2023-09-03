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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);

        ListNode oddPtr = oddHead;
        ListNode evenPtr = evenHead;
        ListNode ptr = head;
        while(ptr!=null){
            oddPtr.next = ptr;
            ptr = ptr.next;
            evenPtr.next = ptr;
            if(ptr!=null){
                ptr = ptr.next;
            }
            oddPtr = oddPtr.next;
            evenPtr = evenPtr.next;
        }
        oddPtr.next = evenHead.next;
        return oddHead.next;
    }
}