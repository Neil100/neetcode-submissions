class PrefixTree {

    Tree tree;

    public PrefixTree() {
        tree = new Tree();
    }

    public void insert(String word) {
        insert(word, 0, tree);
    }

    public boolean search(String word) {
        return search(word, 0, tree);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0, tree);
    }

    boolean startsWith(String prefix, int index, Tree node) {
        if(index == prefix.length()) {
            return true;
        }

        char ch = prefix.charAt(index);

        if(node.pointers[ch-'a'] == null) {
            return false;
        }
        return startsWith(prefix, index+1, node.pointers[ch-'a']);
    }

    void insert(String word, int index, Tree node) {
        if(index == word.length()) {
            node.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);

        if(node.pointers[ch-'a'] == null) {
            node.pointers[ch-'a'] = new Tree();
        }
        insert(word, index+1, node.pointers[ch-'a']);
    }

    boolean search(String word, int index, Tree node) {
        if(index == word.length()) {
            return node.endOfWord;
        }

        char ch = word.charAt(index);

        if(node.pointers[ch-'a'] == null) {
            return false;
        }
        return search(word, index+1, node.pointers[ch-'a']);
    }
}

class Tree {
        Tree[] pointers = new Tree[26];
        boolean endOfWord = false;
}
