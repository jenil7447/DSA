import java.util.Stack;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode first = head;
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        
        while (first != null) {
            stack.push(first.val);
            first = first.next;
            count++;
        }

        ListNode sec = head;

        
        for (int i = 0; i < count / 2; i++) {
            if (sec.val != stack.pop()) {
                return false;
            }
            sec = sec.next;
        }

        return true;
    }
}
