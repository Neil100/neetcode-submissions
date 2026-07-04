class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1; i<temperatures.length; i++) {
            
            while(!stack.isEmpty()) {
                int index = stack.peek();
                if (temperatures[i] > temperatures[index]) {
                    result[index] = i-index;
                    stack.pop();
                } else {
                    break;
                }
            } 
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int index = stack.pop();

            result[index] = 0;
        }

        return result;
    }
}
