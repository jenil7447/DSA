ou are given the head of a doubly linked list.



Reverse the list in-place and return the new head of the reversed list.


Example 1

Input: head = [10, 20, 30]

Output:﻿ [30, 20, 10]

Example 2

Input: head = [1, 3, 5, 7, 9]

Output: [9, 7, 5, 3, 1]
/*
class ListNode {
    int data;
    ListNode prev, next;
    ListNode(int val) {
        this.data = val;
        this.prev = null;
        this.next = null;
    }
}
*/

class Solution {
    public ListNode reverseDLL(ListNode head) {
        if(head == null) return null;
        while(head.next != null){
            ListNode nextNode = head.next;
            ListNode temp = head.prev;
            head.prev = head.next;
            head.next = temp;
            head = nextNode;
        }
        head.next = head.prev;
        head.prev = null;
        return head;
    }
}
// class Solution {
//     public ListNode reverseDLL(ListNode head) {
//         if (head == null) return null;

//         ListNode curr = head;
//         ListNode temp = null;

//         // Swap next and prev for every node in the list
//         while (curr != null) {
//             temp = curr.prev;
//             curr.prev = curr.next;
//             curr.next = temp;

//             // Move to the next node in original order (which is now curr.prev)
//             curr = curr.prev;
//         }

//         // After the loop, temp points to the prev of the original last node (new second node),
//         // so temp.prev is the new head of the reversed list.
//         return temp.prev;
//     }
// }
