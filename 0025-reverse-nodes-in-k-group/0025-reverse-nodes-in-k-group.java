class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;
        ListNode first = head;      // start of current block
        ListNode last = head;       // runner to find k-th node
        ListNode prevGroupTail = null;
        int count = 1;
        while (last != null) {
            if (count % k == 0) {
                ListNode nextBlockHead = last.next; 
                last.next = null;   
                ListNode reversedHead = reverse(first);
                if (prevGroupTail != null) {
                    prevGroupTail.next = reversedHead;
                } else {
                    head = reversedHead;
                }
                prevGroupTail = first;
                first = last = nextBlockHead;
            } else {
                last = last.next;
            }
            count++;
        }
        if (prevGroupTail != null) {
            prevGroupTail.next = first;
        }
        return head;
    }
}
