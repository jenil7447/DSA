class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode top = reverse(head);
        if (n == 1) {
            return reverse(top.next);
        }
        ListNode ptr = top;
        // Move to node BEFORE the node we want to delete
        for (int i = 1; i < n - 1; i++) {
            ptr = ptr.next;
        }

        // Delete nth node
        ptr.next = ptr.next.next;

        // Reverse back
        return reverse(top);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}
