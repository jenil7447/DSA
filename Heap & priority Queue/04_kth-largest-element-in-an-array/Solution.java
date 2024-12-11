class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> prq = new PriorityQueue<>();
        for(int num : nums){
            prq.add(num);
            if(prq.size() > k){
                prq.poll();
            }
        }
        return prq.poll();
    }
}
