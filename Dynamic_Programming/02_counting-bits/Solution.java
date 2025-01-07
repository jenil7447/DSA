
// https://leetcode.com/problems/counting-bits/
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 1; i <= n; i++){
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
// omplexity:

// Time Complexity: 
// 
// O(n)
// Each value from 1 to n is processed in constant time.
// Space Complexity: 
//
// O(n)
// Space is used to store the result in the array ans.
