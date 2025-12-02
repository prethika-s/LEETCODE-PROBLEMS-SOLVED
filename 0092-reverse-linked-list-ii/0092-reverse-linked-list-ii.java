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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode headBeforeReverse=null, headAfterReverse=null, tailBeforeReverse=null, tailAfterReverse=null;
        ListNode dummyhead = head;
        ListNode temp = head;
        ListNode dummyTail = null;
        int ctr = 1;
        while(temp!=null){
            if(ctr==left) {
                headBeforeReverse = temp;
            }
            if(ctr==right) {
                tailBeforeReverse = temp;
                dummyTail = temp.next;
                tailBeforeReverse.next = null;
            }
            temp=temp.next;
            if(ctr>right){
                break;
            }
            ctr++;
        }
        headAfterReverse = reverse(headBeforeReverse);
        tailAfterReverse = headBeforeReverse;
        tailAfterReverse.next = dummyTail;
        if (head == headBeforeReverse) {
            // reversed segment starts from head
            head = headAfterReverse;
        } else {
            ListNode ptr = head;
            while (ptr != null) {
                if (ptr.next == headBeforeReverse) {
                    ptr.next = headAfterReverse;
                    break;
                }
                ptr = ptr.next;
            }
        }
        return head;
    }
}