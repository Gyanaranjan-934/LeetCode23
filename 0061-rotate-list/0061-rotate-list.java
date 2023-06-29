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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        int size = 0;
        ListNode ptr = head;
        while(ptr!=null){
            size++;
            ptr = ptr.next;
        }

        k = k%size;
        if(k==0)return head;

        ListNode slow = head;
        ListNode fast = head;
        // k--;
        while(fast!=null && k!=0){
            fast = fast.next;
            k--;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;

    }
}