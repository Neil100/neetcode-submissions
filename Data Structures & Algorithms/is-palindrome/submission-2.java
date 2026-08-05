class Solution {
    public boolean isPalindrome(String s) {
        int leftIndex = 0, rightIndex = s.length()-1;

        while(leftIndex<rightIndex) {
            char leftChar = s.charAt(leftIndex), rightChar = s.charAt(rightIndex);
            while(!validChar(leftChar) && (leftIndex<rightIndex)) {
                leftIndex++;
                leftChar = s.charAt(leftIndex);
            }

            while(!validChar(rightChar) && (leftIndex<rightIndex)) {
                rightIndex--;
                rightChar = s.charAt(rightIndex);
            }

            if(lowerChar(rightChar) != lowerChar(leftChar))
                return false;

            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    boolean validChar(char leftChar) {
        return ((leftChar>='A' && leftChar<='Z') || (leftChar>='a' && leftChar<='z') || (leftChar>='0' && leftChar<='9'));
    }

    char lowerChar(char ch) {
        if(ch>='A' && ch<='Z') {
            return (char) (ch-'A'+'a');
        }
        return ch;
    }
}
