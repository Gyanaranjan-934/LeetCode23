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
        ListNode ptr = head;
        int size = 0;
        while(ptr!=null){
            ptr=ptr.next;
            size++;
        }
        int comp = size/k;
        int extras = size%k;
        ptr=head;
        ListNode prev = null;
        for(int i=0;i<k&&ptr!=null;i++,extras--){
            res[i]=ptr;
            for(int j=0;j<comp+(extras>0 ? 1 : 0);j++){
                prev = ptr;
                ptr = ptr.next;
            }
            prev.next=null;
        }
        return res;
    }
}