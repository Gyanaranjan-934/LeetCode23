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
    public ListNode partition(ListNode head, int x) {
        ArrayList<ListNode> smallPtr = new ArrayList<>();
        ArrayList<ListNode> largePtr = new ArrayList<>();
        ListNode ptr = head;
        while(ptr!=null){
            ListNode temp = ptr.next;
            ptr.next=null;
            if(ptr.val<x)smallPtr.add(ptr);
            else largePtr.add(ptr);
            ptr = temp;
        }

        ListNode ptrHead = new ListNode(-1);

        ptr = ptrHead;

        for(int i=0;i<smallPtr.size();i++){
            ptr.next = smallPtr.get(i);
            ptr = ptr.next;
        }

        for(int i=0;i<largePtr.size();i++){
            ptr.next = largePtr.get(i);
            ptr = ptr.next;
        }
        return ptrHead.next;
    }
}