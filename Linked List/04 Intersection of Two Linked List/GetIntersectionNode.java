--------------------------------------------------SOLUTION 1-----------------------------------------------------
  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         
        if (headA == null || headB == null) return null;

        // Use two stacks to store the nodes of both lists
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        // Push all nodes of list 1 into stack1
        ListNode tempA = headA;
        while (tempA != null) {
            stackA.push(tempA);
            tempA = tempA.next;
        }

        // Push all nodes of list 2 into stack2
        ListNode tempB = headB;
        while (tempB != null) {
            stackB.push(tempB);
            tempB = tempB.next;
        }

        // Pop from both stacks to find the first common node
        ListNode intersectionNode = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
          ListNode nodeA = stackA.pop();
           ListNode nodeB = stackB.pop();

            if (nodeA == nodeB) {  // Compare the references, not the values
                intersectionNode = nodeA;
            } else {
                break;  // When the references differ, stop the search
            }
        }

        return intersectionNode;  // Return the intersecting node, or null if no intersection
    }

    }

-------------------------------------------Solution 2 ------------------------------------------------------------
  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}
