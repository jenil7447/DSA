class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] arr = new char[word1.length() + word2.length()];
        int index = 0, i = 0, j = 0;
        
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                arr[index++] = word1.charAt(i++);
            }
            if (j < word2.length()) {
                arr[index++] = word2.charAt(j++);
            }
        }
        
        return new String(arr);
    }
}
