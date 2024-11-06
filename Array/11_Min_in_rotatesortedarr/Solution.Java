class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
// In this it is given that we have to find the smallest element from the given array and the array is roated and sorted and also given that we have to solvw in O(nlogn) 
so, we have to solve with the binary search.in code the logic is that we have tofind the smallest element througth binary search in that first we find the middle element that we check 
the middle element with the rigth most element if the rigth is < mid we know/understood that the smallest element is in right side so again search in right array.thus we find the solution
