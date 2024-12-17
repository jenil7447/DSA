class WordDictionary {
    class TrieNode { 
        TrieNode[] link;
        boolean flag;

        public TrieNode() {
            link = new TrieNode[26];
            flag = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.link[index] == null) {
                node.link[index] = new TrieNode();
            }
            node = node.link[index];
        }
        node.flag = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (node == null) return false; 
        if (index == word.length()) return node.flag; 
        char ch = word.charAt(index);

        if (ch == '.') { 
            for (TrieNode linkpoint : node.link) {
                if (linkpoint != null && searchHelper(word, index + 1, linkpoint)) {
                    return true;
                }
            }
            return false;
        } else { 
            int linkIndex = ch - 'a';
            return searchHelper(word, index + 1, node.link[linkIndex]); 
        }
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
