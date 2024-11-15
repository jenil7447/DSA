class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> hashTable = new HashMap<>();
        Node current = head;

        while (current != null) {
            hashTable.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node copy = hashTable.get(current);
            copy.next = hashTable.get(current.next);
            copy.random = hashTable.get(current.random); 
            current = current.next;
        }
        return hashTable.get(head);
    }
}
