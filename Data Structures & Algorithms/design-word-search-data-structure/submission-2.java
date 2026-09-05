class WordDictionary {
    Trie headTrie;
    public WordDictionary() {
        headTrie = new Trie();
    }

    public void addWord(String word) {
        addWord(word, 0, headTrie);
    }

    public boolean search(String word) {
        return search(word, 0, headTrie);
    }

    private void addWord(String word, int index, Trie trieNode) {
        if(index == word.length()) {
            trieNode.isLast = true;
            return;
        }
        char currentChar = word.charAt(index);
        if(trieNode.trieArray[currentChar-'a'] == null) {
            trieNode.trieArray[currentChar-'a'] = new Trie();
        }
        addWord(word, index+1, trieNode.trieArray[currentChar-'a']);
    }

    private boolean search(String word, int index, Trie trieNode) {
        if(trieNode==null)
            return false;

        if(word.length()==index) {
            if(trieNode.isLast) {
                return true;
            }
            return false;
        }

        char currentChar = word.charAt(index);
        if(currentChar == '.') {
            for(int i=0; i<26; i++) {
                if(trieNode.trieArray[i]!=null) {
                    if(search(word, index+1, trieNode.trieArray[i])) {
                        return true;
                    }
                }
            }
        } else {
            return search(word, index+1, trieNode.trieArray[currentChar-'a']);
        }
        return false;
    }
}

class Trie {
    Trie[] trieArray = new Trie[26];
    boolean isLast = false;
}
