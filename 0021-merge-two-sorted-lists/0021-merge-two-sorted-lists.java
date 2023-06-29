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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode head = new ListNode(-1);
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode ptr = head;

        while(ptr1!=null && ptr2!=null){
            if(ptr1.val<ptr2.val){
                ptr.next = ptr1;
                ptr1 = ptr1.next;
            }else{
                ptr.next = ptr2;
                ptr2 = ptr2.next;
            }
            ptr = ptr.next;
        }
        while(ptr1!=null){
            ptr.next = ptr1;
            ptr1 = ptr1.next;
            ptr = ptr.next;
        }
        while(ptr2!=null){
            ptr.next = ptr2;
            ptr2 = ptr2.next;
            ptr = ptr.next;
        }
        return head.next;
    }
}