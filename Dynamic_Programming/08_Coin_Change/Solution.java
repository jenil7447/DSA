public class Solution {
  int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    int[] minCoinsDP = new int[amount + 1];

    for (int i = 1; i <= amount; i++) {
      minCoinsDP[i] = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE)
          minCoinsDP[i] = Math.min(minCoinsDP[i], 1 + minCoinsDP[i - coin]);
      }
    }
    return minCoinsDP[amount] == Integer.MAX_VALUE ? -1 : minCoinsDP[amount];
  }

}
