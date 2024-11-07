class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (current < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(current, maxProd * current);
            minProd = Math.min(current, minProd * current);
            result = Math.max(result, maxProd);
        }

        return result;
    }
}
// this the optimal approch with Kadane's Algorithm 
//Track both maximum and minimum products at each position: Since the product of two negative numbers becomes positive, we need to track the minimum product at each step as well. If the current number is negative, the minimum product may become the maximum when multiplied by it.
//Iterate through the array once: At each element:
//Calculate the possible maximum product up to that element by multiplying the current element with both the current maximum and minimum products.
//Update the maximum and minimum products accordingly.
//Keep track of the global maximum: As you iterate, update the global maximum with the highest product encountered so far.

// Consider nums = [2, 3, -2, 4]:

// Initialize maxProd = 2, minProd = 2, result = 2.
// i = 1, current = 3:
// maxProd = max(3, 2 * 3) = 6
// minProd = min(3, 2 * 3) = 3
// result = max(2, 6) = 6
// i = 2, current = -2:
// Swap maxProd and minProd because current is negative.
// maxProd = max(-2, 3 * -2) = -2
// minProd = min(-2, 6 * -2) = -12
// result = max(6, -2) = 6
// i = 3, current = 4:
// maxProd = max(4, -2 * 4) = 4
// minProd = min(4, -12 * 4) = -48
// result = max(6, 4) = 6
// The maximum product of any subarray in [2, 3, -2, 4] is 6, which is the final result.

// Time Complexity : O(n)
// space ccomplexity o(1)




