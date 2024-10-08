import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int cumulativeSum = 0;
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        
        // Initialize with 0 sum having 1 count
        prefixSums.put(0, 1);

        for (int num : nums) {
            cumulativeSum += num; // Update the cumulative sum

            // Check if (cumulativeSum - k) exists in the prefixSums map
            if (prefixSums.containsKey(cumulativeSum - k)) {
                count += prefixSums.get(cumulativeSum - k);
            }

            // Update the prefixSums map with the current cumulative sum
            prefixSums.put(cumulativeSum, prefixSums.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }
}
