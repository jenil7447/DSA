class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; 
        
        Map<String, List<String>> allComboDict = new HashMap<>();
        int wordLength = beginWord.length();
        
        for (String word : wordList) {
            for (int i = 0; i < wordLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
                allComboDict.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
            }
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String currentWord = current.getKey();
            int level = current.getValue();
            
            for (int i = 0; i < wordLength; i++) {
                String newWord = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1);
                
                for (String neighbor : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (neighbor.equals(endWord)) {
                        return level + 1; 
                    }
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(new Pair<>(neighbor, level + 1));
                    }
                }
            }
        }
        return 0;
    } 
}
