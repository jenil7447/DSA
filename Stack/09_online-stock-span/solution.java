class StockSpanner {
    private class Node {
        int price;
        int count;
        Node prev;
        
        Node(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }
    private Node tail; 

    public StockSpanner() {
        tail = null;
    }

    public int next(int price) {
        int count = 1;
        while (tail != null && tail.price <= price) {
            count += tail.count;
            tail = tail.prev; 
        }
        Node newNode = new Node(price, count);
        newNode.prev = tail;
        tail = newNode;

        return count;
    }
}
