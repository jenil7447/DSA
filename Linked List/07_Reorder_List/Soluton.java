
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while(curr != null){
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        ListNode first = head;
        ListNode mid = prev;
        while(mid != null){
            ListNode tempFirst = first.next;
            ListNode tempMid = mid.next;
            first.next = mid;
            mid.next = tempFirst;
            first = tempFirst;
            mid = tempMid;
        }
    }
}
