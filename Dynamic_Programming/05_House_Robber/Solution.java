// recursion
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         return recur(nums, n - 1);
//     }

//     public int recur(int nums[], int index) {
//         //base case
//         if (index == 0) {
//             return nums[0];
//         }
//         if (index == -1) {
//             return 0;
//         }
//         //pick and no pick logic
//         int pick = nums[index] + recur(nums, index - 2);
//         int noPick = 0 + recur(nums, index - 1);
//         return Math.max(pick, noPick);
//     }

// }
// top down
// class Solution {
//     // shifting logic
//      public int rob(int[] nums) {
//          int n = nums.length;
//          int[] store = new int[n+1];
//          Arrays.fill(store,-1);
//          return recur(nums,n, store);
//      }
//      public int recur(int[] nums, int index, int[] store){
//          //base case
//          if(index==1){
//              store[index] = nums[0];
//              return nums[0];
//          }
//          if(index==0){
//              store[index] = 0;
//              return 0;
//          }
//          if (store[index]!=-1){
//              return store[index];
//          }

//          //pick and no pick logic
//          int pick = nums[index-1] + recur(nums,index-2, store);
//          int noPick = 0 + recur(nums,index-1, store);
//          store[index] = Math.max(pick,noPick);
//          return store[index];
//      }
// }
// // bottom up
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] store = new int[n + 1];
//         store[0] = 0;
//         store[1] = nums[0];
//         for (int i = 2; i < n + 1; i++) {
//             //pick and no pick logic
//             int pick = nums[i - 1] + store[i - 2];
//             int noPick = 0 + store[i - 1];
//             store[i] = Math.max(pick, noPick);
//         }
//         return store[n];
//     }

// }

// //optimized
class Solution{
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int prev2 = 0;
        int prev1 = nums[0];
        int ans = 0;
        for(int state=2;state<n+1;state++){
            int pick = nums[state-1] + prev2;
            int noPick = 0 + prev1;
            ans = Math.max(pick,noPick);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}
