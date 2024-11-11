class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1, right = maxPile;
        int ans = maxPile;  

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int requiredHours = evaluateNBPH(piles, mid, h);

            if (requiredHours <= h) {
                ans = mid;  
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        return ans;
    }

    private int evaluateNBPH(int[] piles, int x, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + x - 1) / x;  
            if (hours > h) { 
                return Integer.MAX_VALUE;
            }
        }
        
        return hours;
    }
}
// time complexity :O(N⋅log(maxPile)) Space Complexity: O(1)
