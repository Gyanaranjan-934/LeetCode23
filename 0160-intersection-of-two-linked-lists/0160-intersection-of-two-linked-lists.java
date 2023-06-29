/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode ptr = headA;
        while(ptr!=null){
            set.add(ptr);
            ptr = ptr.next;
        }
        ptr = headB;
        while(ptr!=null){
            if(set.contains(ptr))return ptr;
            ptr = ptr.next;
        }
        return ptr;
    }
}