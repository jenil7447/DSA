class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = l1;
        ListNode prev = null;

        int carry = 0;

        while (l1 != null && l2 != null) {

            int sum = l1.val + l2.val + carry;

            l1.val = sum % 10;
            carry = sum / 10;

            prev = l1;

            l1 = l1.next;
            l2 = l2.next;
        }

        // l2 still has nodes
        if (l2 != null) {
            prev.next = l2;
            l1 = l2;
        }

        // Process remaining nodes
        while (l1 != null) {

            int sum = l1.val + carry;

            l1.val = sum % 10;
            carry = sum / 10;

            prev = l1;
            l1 = l1.next;
        }

        // Only create a node if carry is still remaining
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }

        return head;
    }
}
