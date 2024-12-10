
class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a max-heap using PriorityQueue with reverse order comparator
        PriorityQueue<Integer> prq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all stones to the max-heap
        for (int stone : stones) {
            prq.add(stone);
        }
        
        // Process the stones until one or no stones are left
        while (prq.size() > 1) {
            int first = prq.poll(); // Remove the heaviest stone
            int second = prq.poll(); // Remove the second heaviest stone
            
            // If the two stones are not of equal weight
            if (first != second) {
                prq.add(first - second); // Add the remaining weight back to the heap
            }
        }
        
        // If there are no stones left, return 0; otherwise, return the last stone
        return prq.isEmpty() ? 0 : prq.peek();
    }
}
