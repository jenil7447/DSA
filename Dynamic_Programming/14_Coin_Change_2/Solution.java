class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recurse(amount, coins, n - 1, dp);
    }

    private int recurse(int amount, int[] coins, int index, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index < 0) {
            return 0;
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int include = recurse(amount - coins[index], coins, index, dp);
        int exclude = recurse(amount, coins, index - 1, dp);
        dp[index][amount] = include + exclude;
        return dp[index][amount];
    }
}
