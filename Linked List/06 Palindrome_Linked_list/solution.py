# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        slow = head
        fast = head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        prev = None

        while slow is not None:
            next_node = slow.next
            slow.next = prev
            prev = slow
            slow = next_node

        ptr = head
        second = prev

        while second is not None:
            if ptr.val != second.val:
                return False

            ptr = ptr.next
            second = second.next

        return True
