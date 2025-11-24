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
    public ListNode insert(int data, ListNode result){
        ListNode node = new ListNode(data);
        node.next = result;
        result = node;
        return result;
    }
    public ListNode reverse(ListNode list, ListNode newList){
        if(list==null){
            return newList;
        }
        ListNode newNode = new ListNode(list.val);
        newNode.next = newList;
        newList = newNode;
        list = list.next;
        return reverse(list, newList);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tempSum = 0;
        int carry = 0;
        ListNode result = null;
        while(l1!=null && l2!=null){
            int d1 = l1.val;
            int d2 = l2.val;
            tempSum = d1+d2+carry;
            carry = (tempSum>=10)? (tempSum/10) : 0;
            l1 = l1.next;
            l2 = l2.next;
            result = insert(tempSum%10,result);
        }
        if(l1!=null){
            while(l1!=null){
                int d1 = l1.val;
                tempSum = d1+carry;
                carry = (tempSum>=10)? (tempSum/10) : 0;
                l1 = l1.next;
                result = insert(tempSum%10,result);
            }
        }
        if(l2!=null){
            while(l2!=null){
                int d2 = l2.val;
                tempSum = d2+carry;
                carry = (tempSum>=10)? (tempSum/10) : 0;
                l2 = l2.next;
                result = insert(tempSum%10,result);
            }
        }
        if(carry!=0) result = insert(carry,result);
        return reverse(result,null);
    }
}