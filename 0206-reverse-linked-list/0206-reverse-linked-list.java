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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode temp = new ListNode(head.val);
        ListNode ptr = head.next;
        while(ptr!=null){
            ListNode newNode = new ListNode(ptr.val);
            newNode.next = temp;
            temp = newNode;
            ptr = ptr.next;
        }
        return temp;
    }
}