class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftLimit = new int[n], rightLimit = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {

            while(!stack.isEmpty()) {
                int top = stack.peek();

                if(heights[top]<=heights[i]) {
                    break;
                } else {
                    stack.pop();
                    rightLimit[top] = i;
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int top = stack.pop();

            rightLimit[top] = n;
        }

        for(int i=n-1; i>=0; i--) {

            while(!stack.isEmpty()) {
                int top = stack.peek();

                if(heights[top]<=heights[i]) {
                    break;
                } else {
                    stack.pop();
                    leftLimit[top] = i;
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int top = stack.pop();

            leftLimit[top] = -1;
        }
        int sol = Integer.MIN_VALUE;

        System.out.println(leftLimit);
        for(int i=0; i<n; i++) {
            sol = Integer.max(sol, heights[i]*((rightLimit[i]-leftLimit[i])-1));
        }

        return sol;
    }
}
