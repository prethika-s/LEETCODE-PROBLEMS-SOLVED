/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p=head;
        ListNode q=head;
        while(q!=null && q.next!=null){
            q=q.next.next;
            p=p.next;
         if(p==q){
            return true;
        }  
        }
        return false;
    }
}