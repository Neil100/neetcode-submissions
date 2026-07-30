class Solution {
    List<String> sol;
    int num;
    public List<String> generateParenthesis(int n) {
        sol = new ArrayList<>();

        if(n==0)
            return sol;
        num = n;
        StringBuilder str = new StringBuilder();

        generateParenthesisList(0, n, n, str);

        return sol;
    }

    void generateParenthesisList(int index, int open, int closed, StringBuilder curString) {
        if(index==2*num) {
            sol.add(new String(curString));
            return;
        }

        if(open>0 && closed>open) {
            curString.append('(');
            generateParenthesisList(index+1, open-1, closed, curString);
            curString.deleteCharAt(curString.length()-1);

            curString.append(')');
            generateParenthesisList(index+1, open, closed-1, curString);
            curString.deleteCharAt(curString.length()-1);
        } else if(closed==open) {
            curString.append('(');
            generateParenthesisList(index+1, open-1, closed, curString);
            curString.deleteCharAt(curString.length()-1);
        } else if(open==0) {
            curString.append(')');
            generateParenthesisList(index+1, open, closed-1, curString);
            curString.deleteCharAt(curString.length()-1);
        }
    }
}
