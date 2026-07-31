class Solution {
    List<List<String>> sol;
    public List<List<String>> partition(String s) {
        
        sol = new ArrayList<>();

        List<String> currentList = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        findPartitions(s, 0, currentList, currentString);

        return sol;
    }

    void findPartitions(String s, int index, List<String> currentList, StringBuilder currentString) {
        if(index == s.length()) {

            if(isPalindrome(currentString)) {
                currentList.add(new String(currentString));
                sol.add(new ArrayList<>(currentList));
                currentList.remove(currentList.size()-1);
            }
            return;    
        }

        currentString.append(s.charAt(index));
        // if(isPalindrome(currentString)) {
            findPartitions(s, index+1, currentList, currentString);
        // }

        currentString.deleteCharAt(currentString.length()-1);

        if(currentString.length()!=0 && isPalindrome(currentString)) {
            currentList.add(new String(currentString));
            currentString = new StringBuilder();
            currentString.append(s.charAt(index));

            findPartitions(s, index+1, currentList, currentString);

            currentString = new StringBuilder(currentList.get(currentList.size()-1));

            currentList.remove(currentList.size()-1);
        }

    }

    boolean isPalindrome(StringBuilder string) {
        int left = 0, right = string.length()-1;

        while(left<=right) {
            if(string.charAt(left++)!=string.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
