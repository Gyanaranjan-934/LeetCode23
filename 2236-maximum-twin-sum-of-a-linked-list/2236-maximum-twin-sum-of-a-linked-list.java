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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prevPtr = slow;
        ListNode currPtr = slow.next;
        while(currPtr!=null){
            ListNode nextPtr = currPtr.next;
            currPtr.next = prevPtr;
            prevPtr = currPtr;
            currPtr = nextPtr;
        }
        ListNode head1 = head;
        ListNode head2 = prevPtr;
        int sum = 0;
        while(head1.next != head2){
            int currSum = head1.val+head2.val;
            sum = Math.max(currSum,sum);
            head1 = head1.next;
            head2 = head2.next;
        }
        int currSum = head1.val+head2.val;
        sum = Math.max(currSum,sum);
        return sum;
    }
}