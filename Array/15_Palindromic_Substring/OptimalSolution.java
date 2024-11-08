class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            
            count += expandFromCenter(s, i, i);
            count += expandFromCenter(s, i, i + 1);
        }
        return count;
    }

    private int expandFromCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;  
            left--;   
            right++;  
        }
        return count;
    }
}
---------------------------------------------------------------------------------------------------
//   To solve the Longest Palindromic Substring problem optimally, it’s helpful to take a dynamic programming or center-expansion approach. Here’s a breakdown of how to approach it optimally:

// 1. Problem Analysis
// A palindrome reads the same forwards and backward. Given a string s, you need to find the longest substring of s that is a palindrome. This is a substring problem, so you’ll focus on contiguous characters in s.

// 2. Naive Solution (for Insight)
// A brute-force approach would involve checking every possible substring of s to see if it's a palindrome, and then tracking the longest palindrome found. However, this has a time complexity of 
// O(n^3) which is too slow for large strings, as it involves both generating all substrings and checking if each is a palindrome.

// 3. Optimal Approach: Expanding Around Center
// A more efficient solution involves taking advantage of the fact that a palindrome mirrors around its center. For each possible center in s, expand outward to check for the longest palindrome.

// Why Expanding Around Centers Works
// Each palindrome has a center:

// If the palindrome length is odd (e.g., "aba"), it has a single character center.
// If the palindrome length is even (e.g., "abba"), it has two characters at the center.
// By checking each position in the string as a possible center (including both single and two-character centers), you can expand outward to find the longest palindrome centered there.

// Steps for Expanding Around Center
// For each index i in s, treat i as a center:
// Expand around a single center for odd-length palindromes.
// Expand around a two-character center for even-length palindromes.
// Track the longest palindrome found during these expansions.
// Code Implementation
// This approach has a time complexity of O(n^2) 
// 
// 
