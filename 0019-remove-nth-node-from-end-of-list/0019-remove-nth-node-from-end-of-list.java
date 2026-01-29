class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head to simplify edge cases
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;

        // Move `first` pointer `n+1` steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until `first` reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // `second` is now at the node before the target node
        second.next = second.next.next;

        // Return the modified list starting from `dummy.next`
        return dummy.next;
    }
}