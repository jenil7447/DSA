class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> prq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < score.length; i++) {
            prq.add(new int[]{score[i], i}); 
        }
        String[] result = new String[score.length];
        int rank = 1;
        while (!prq.isEmpty()) {
            int[] current = prq.poll();
            int index = current[1];
            if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank);
            }
            rank++;
        }
        return result;
    }
}
