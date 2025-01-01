// https://leetcode.com/problems/minimum-cost-to-convert-string-i/
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // Initialize distance array with maximum values
        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0; // Cost to transform a character into itself is 0
        }

        // Populate initial transformation costs
        for (int i = 0; i < cost.length; i++) {
            int start = original[i] - 'a';
            int end = changed[i] - 'a';
            dis[start][end] = Math.min(dis[start][end], cost[i]);
        }

        // Apply Floyd-Warshall algorithm to calculate minimum transformation costs
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dis[i][k] < Integer.MAX_VALUE) {
                    for (int j = 0; j < 26; j++) {
                        if (dis[k][j] < Integer.MAX_VALUE) {
                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                        }
                    }
                }
            }
        }

        // Calculate the total cost to transform source into target
        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';
            if (dis[c1][c2] == Integer.MAX_VALUE) {
                return -1L; // Transformation is not possible
            } else {
                ans += (long) dis[c1][c2];
            }
        }
        return ans;
    }
}
