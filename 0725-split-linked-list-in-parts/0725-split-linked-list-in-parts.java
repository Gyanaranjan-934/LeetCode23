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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int size = 0;
        ListNode ptr = head;
        while(ptr!=null){
            ptr = ptr.next;
            size++;
        }
        int comp = size/k;
        int extra = size%k;
        ptr = head;
        ListNode prev = null;

        // Loop through each part.
        for (int i = 0; ptr != null && i < k; i++, extra--) {
            // Store the current ptr as the start of the current part.
            res[i] = ptr;

            // Traverse comp + 1 nodes if there are remaining extra nodes (extra > 0).
            // Otherwise, traverse only comp nodes.
            for (int j = 0; j < comp + (extra > 0 ? 1 : 0); j++) {
                prev = ptr;
                ptr = ptr.next;
            }

            // Disconnect the current part from the rest of the list by setting prev.next to null.
            if (prev != null) {
                prev.next = null;
            }
        }

        // Return the array of k parts.
        return res;

    }
}