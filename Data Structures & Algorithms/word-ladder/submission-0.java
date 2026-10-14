class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> list = new HashSet<>();
        Set<String> wordsUsed = new HashSet<>();
        if(beginWord.equals(endWord))
            return 0;

        for(String word : wordList) {
            list.add(word);
        }

        Queue<String> que = new LinkedList<>();
        que.add(beginWord);
        wordsUsed.add(beginWord);
        int sol=1;
        int currentLength = 0;
        int levelSize = que.size();

        while(!que.isEmpty()) {

            String current = que.poll();
            currentLength++;
            wordsUsed.add(current);
            if(current.equals(endWord)) {
                return sol;
            }

            for(int i=0; i<current.length(); i++) {
                StringBuilder strBuild = new StringBuilder(current);                
                for(int j=0; j<26; j++) {
                    char nChar = (char)('a'+j);
                    strBuild.setCharAt(i, nChar);
                    String newStr = strBuild.toString();
                    if(list.contains(newStr) && !wordsUsed.contains(newStr)) {
                        que.add(newStr);
                    }
                }
            }

            if(currentLength == levelSize) {
                currentLength=0;
                levelSize = que.size();
                sol++;
            }
        }

        return 0;
    }
}
