class Solution {

//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         return recur(n,cost);
//     }
//     int recur(int n, int[] cost){
//         if(n == 0 || n == 1 ) return 0;
//         int firstStep = cost[n-1] + recur(n-1,cost);
//         int secoundStep = cost[n-2] + recur(n-2,cost);
//         return Math.min(firstStep,secoundStep);
//     }
// two time recursion time complexity : 2^n;

// top -dowen approach
//   public int minCostClimbingStairs(int[] cost){
//     int n = cost.length;
//     int[] store = new int[n+1];
//     Arrays.fill(store,-1);
//     return recur(n,cost,store);
//   }  
//   int recur(int n, int[] cost, int[] store){
//     if( n == 0 || n == 1){
//         store[n] = 0;
//         return store[n];
//     }
//     if(store[n] != -1) return store[n];
//     int firstStep = cost[n-1] + recur(n-1,cost,store);
//     int secoundStep = cost[n-2] + recur(n-2,cost,store);
//     store[n] = Math.min(firstStep,secoundStep);
//     return store[n];
//   }

// bottom up approach
//         public int minCostClimbingStairs(int[] cost){
//             int n = cost.length;
//             int[] store = new int[n+1];
//             store[0] = 0;
//             store[1] = 0;
//             for(int i = 2; i <= n ; i++){
//                 int firstStep = cost[i-1] + store[i-1];
//                 int secoundStep = cost[i-2] + store[i-2];
//                 store[i] = Math.min(firstStep,secoundStep);
//             }
//             return store[n];
//         }

// optimized
  public int minCostClimbingStairs(int[] cost){
            int n = cost.length;
            int[] store = new int[n+1];
            int prevTwo = 0;
            int prevOne = 0;
            int ans = 0;
            for(int i = 2; i <= n ; i++){
                int firstStep = cost[i-1] + prevOne;
                int secoundStep = cost[i-2] + prevTwo;
                ans = Math.min(firstStep,secoundStep);
                prevTwo = prevOne;
                prevOne = ans; 
            }
            return ans;
        }


}
