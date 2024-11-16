// This solution cant resolve for large no of testcase 
// this is a brute force approch
class LRUCache {
    private List<Node> cache; 
    private int n;

    public LRUCache(int capacity) {
        this.cache = new ArrayList<>();
        this.n = capacity;
    }

    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).key == key) {
                int val = cache.get(i).value;
                Node temp = cache.get(i);
                cache.remove(i);
                cache.add(temp);

                return val;
            }
        }
        return -1; 
    }

    public void put(int key, int value) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).key == key) {
                cache.remove(i);
                cache.add(new Node(key, value));
                return;
            }
        }
        if (cache.size() == n) {
            cache.remove(0);
        }
        cache.add(new Node(key, value));
    }
    private static class Node {
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
