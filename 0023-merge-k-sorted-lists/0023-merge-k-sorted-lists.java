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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        List<Integer> arr=new ArrayList<>();
        int i=0;
        for(int j=0;j<lists.length;j++){
            ListNode temp=lists[j];
        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }

    }
    Collections.sort(arr);
    ListNode dummy=new ListNode(-1);
    ListNode curr=dummy;
    for(int j=0;j<arr.size();j++){
        curr.next=new ListNode(arr.get(j));
        curr=curr.next;
    }
    return dummy.next;
    }
}