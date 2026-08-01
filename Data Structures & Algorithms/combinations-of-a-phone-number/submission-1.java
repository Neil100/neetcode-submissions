class Solution {
    Map<Character, char[]> map;
    List<String> sol;
    public List<String> letterCombinations(String digits) {
        
        map = new HashMap<>();
        sol = new ArrayList<>();

        if(digits.length()==0)
            return sol;

        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        StringBuilder currentComb = new StringBuilder();
        createCombination(digits, 0, currentComb);

        return sol;
    }

    void createCombination(String digits, int index, StringBuilder currentComb) {
        if(index == digits.length()) {
            sol.add(new String(currentComb));
            return;
        }

        char ch = digits.charAt(index);

        char[] chArray = map.get(ch);

        for(int i=0; i<chArray.length; i++) {
            currentComb.append(chArray[i]);
            createCombination(digits, index+1, currentComb);
            currentComb.deleteCharAt(currentComb.length()-1);
        }
    }

}
