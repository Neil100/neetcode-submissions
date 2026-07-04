class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    // int min;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        // min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        // min = ;
        minStack.push(minStack.size()==0 ? val : Integer.min(minStack.peek(), val));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
