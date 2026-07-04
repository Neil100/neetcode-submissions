class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<tokens.length; i++) {
            if(tokens[i].compareTo("+")==0) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num1+num2);
            } else if(tokens[i].compareTo("-")==0) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2-num1);
            } else if(tokens[i].compareTo("/")==0) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2/num1);
            } else if(tokens[i].compareTo("*")==0) {
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num1*num2);
            } else {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
        }

        return stack.pop();
    }
}
