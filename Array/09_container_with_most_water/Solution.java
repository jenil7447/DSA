class Solution {
    public int maxArea(int[] height) {
         int maxArea = Integer.MIN_VALUE, start = 0, end = height.length - 1;

        while (start < end) {
            int currHeight = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, currHeight * (end - start));

            while (start < end && height[start] <= currHeight) {
                start++;
            }

            while (start < end && height[end] <= currHeight) {
                end--;
            }
        }

        return maxArea;
    }
}
