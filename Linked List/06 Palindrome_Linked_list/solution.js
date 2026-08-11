/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val === undefined ? 0 : val)
 *     this.next = (next === undefined ? null : next)
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {

    // Find the middle of the list
    let slow = head;
    let fast = head;

    while (fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Reverse the second half
    let prev = null;

    while (slow !== null) {
        let next = slow.next;
        slow.next = prev;
        prev = slow;
        slow = next;
    }

    // Compare first half with reversed second half
    let ptr = head;
    let second = prev;

    while (second !== null) {
        if (ptr.val !== second.val) {
            return false;
        }

        ptr = ptr.next;
        second = second.next;
    }

    return true;
};
