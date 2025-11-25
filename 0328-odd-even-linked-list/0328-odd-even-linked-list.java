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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        ListNode odd = null, oTail = null;
        ListNode even = null, eTail = null;
        int idx=1;
        while(temp!=null){
            int data = temp.val;
            ListNode newNode = new ListNode(data);
            if(idx%2==0){
                if(even==null){
                    even = newNode;
                    eTail = newNode;
                }
                else{
                    eTail.next = newNode;
                    eTail = newNode;
                }
            }
            else{
                if(odd==null){
                    odd = newNode;
                    oTail = newNode;
                }
                else{
                    oTail.next = newNode;
                    oTail = newNode;
                }
            }
            idx++;
            temp = temp.next;
        }
        if(odd==null){
            return even;
        }
        oTail.next = even;
        return odd;
    }
}