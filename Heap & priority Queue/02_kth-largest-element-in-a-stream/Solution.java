
class KthLargest {
    private PriorityQueue<Integer> queue; // Min-Heap
    private int k;

    // Constructor
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();

        // Add elements to the heap
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll(); // Remove the smallest to maintain size k
            }
        }
    }

    // Add method
    public int add(int val) {
        queue.add(val); // Add the new value
        if (queue.size() > k) {
            queue.poll(); // Remove the smallest if size exceeds k
        }
        return queue.peek(); // The root is the k-th largest element
    }
}
