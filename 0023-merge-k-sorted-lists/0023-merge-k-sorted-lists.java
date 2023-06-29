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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x,y)->x.val-y.val);
        for(ListNode ptr:lists){
            if(ptr!=null)
                pq.add(ptr);
        }
        ListNode head = new ListNode(-1);
        ListNode ptr = head;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            ptr.next = node;
            ptr = ptr.next;
            // ptr.next = null;
            if(node.next!=null)pq.add(node.next);
        }   
        return head.next;
    }
}