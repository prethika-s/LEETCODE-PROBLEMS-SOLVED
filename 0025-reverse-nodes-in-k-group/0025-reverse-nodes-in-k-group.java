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
    public static ListNode reverse(ListNode first){
        ListNode prev = null;
        ListNode curr = first;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode tempHead = head;
        ListNode nextHead=head;
        ListNode dummyHead=head;
        ListNode tailBeforeReverse, headBeforeReverse, headAfterReverse, tailAfterReverse;
        int itr = 1;
        while(temp!=null){
            for(int i=0; i<k-1 && temp!=null; i++){
                temp=temp.next;
            }
            if(temp==null) break;
            tailBeforeReverse = temp;
            headBeforeReverse = tempHead;
            nextHead = tailBeforeReverse.next;
            tailBeforeReverse.next = null;
            headAfterReverse = reverse(headBeforeReverse);
            tailAfterReverse = headBeforeReverse;
            tailAfterReverse.next = nextHead;
            if(itr==1) dummyHead = headAfterReverse;
            else {
                // reuse tempHead to find the previous group's tail
                tempHead = dummyHead;
                while (tempHead != null && tempHead.next != headBeforeReverse) {
                    tempHead = tempHead.next;
                }
                if (tempHead != null) {
                    tempHead.next = headAfterReverse;   // link prev group to this reversed group
                }
            }
            temp = tailAfterReverse.next;
            tempHead = temp;
            itr++;
        }
        return dummyHead;
    }
}