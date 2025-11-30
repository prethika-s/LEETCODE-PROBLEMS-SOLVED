/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while(ptrA!=null && ptrB!=null){
            if(!set.contains(ptrA)) set.add(ptrA);
            else return ptrA;
            if(!set.contains(ptrB)) set.add(ptrB);
            else return ptrB;
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        if(ptrA==null && ptrB==null){
            return null;
        }
        else if(ptrA!=null){
            while(ptrA!=null){
                if(!set.contains(ptrA)) set.add(ptrA);
                else return ptrA;
                ptrA = ptrA.next;
            }
        }
        else{
            while(ptrB!=null){
                if(!set.contains(ptrB)) set.add(ptrB);
                else return ptrB;
                ptrB = ptrB.next;
            }
        }
        return null;
    }
}