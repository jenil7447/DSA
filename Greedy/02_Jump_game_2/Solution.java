// class Solution {
//     public int jump(int[] nums) {
//         return calcSteps(0, 0, nums);
//     }

//     private int calcSteps(int index, int jumpCount, int[] nums) {

//         if (index >= nums.length - 1) {
//             return jumpCount;
//         }

//         int val = nums[index];
//         int minJumps = Integer.MAX_VALUE;
        
//         for (int i = 1; i <= val; i++) {
//             minJumps = Math.min(minJumps, calcSteps(index + i, jumpCount + 1, nums));
//         }

//         return minJumps;
//     }
// }
// class Solution {
//     public int jump(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp,-1);
//         return calcSteps(0, nums, dp);
//     }

//     private int calcSteps(int index, int[] nums, int[] dp) {
//         if (index >= nums.length - 1) {
//             return 0;
//         }
//         if (dp[index] != -1) {
//             return dp[index];
//         }

//         int val = nums[index];
//         int minJumps = Integer.MAX_VALUE;

//         for (int i = 1; i <= val; i++) {
//             if (index + i < nums.length) {
//                 minJumps = Math.min(minJumps, calcSteps(index + i, nums, dp) + 1);
//             }
//         }
//         dp[index] = minJumps;
//         return minJumps;
//     }
// }
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;       
        int currentEnd = 0; 
        int nextEnd = 0;   

        for (int i = 0; i < n - 1; i++) {
            nextEnd = Math.max(nextEnd, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = nextEnd; 
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}

