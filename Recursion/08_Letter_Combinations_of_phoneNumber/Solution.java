class Solution {
    public static char[][] seq = {
                                {'a', 'b', 'c'},   
                                {'d', 'e', 'f'},   
                                {'g', 'h', 'i'},
                                {'j', 'k', 'l'}, 
                                {'m', 'n', 'o'}, 
                                {'p', 'q', 'r', 's'},
                                {'t', 'u', 'v'},   
                                {'w', 'x', 'y', 'z'}  
                            };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) 
            return new ArrayList<>();

        List<String> result = new ArrayList<>();

        generateCombinations(digits, 0, new StringBuilder(), result);

        return result;
    }
    public void generateCombinations(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        int digit = digits.charAt(index) - '2';

        for (char ch : seq[digit]) {
            current.append(ch);
            generateCombinations(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }        
    }
}
