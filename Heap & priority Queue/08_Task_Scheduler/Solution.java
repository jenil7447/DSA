class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char task : tasks) {
            map.put(task, map.getOrDefault(task,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap.addAll(map.values()); 
        int cycle = 0;
        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>(); 
            for(int i=0; i<n+1 ; i++) {
                if(!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }
            for(int i=0; i<temp.size(); i++) {
                if(temp.get(i) - 1  > 0) {
                    maxHeap.add(temp.get(i)-1);
                }
            }
            cycle += maxHeap.isEmpty() ? temp.size() : n+1;
        }
        return cycle;
    }
}
