class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[][] output = new float[position.length][2];

        for(int i=0; i<position.length; i++) {
            output[i][0] = position[i];
            output[i][1] = ((float)(target - position[i])) / (float) speed[i];
        }

        Arrays.sort(output, (f1, f2) ->  Float.compare(f2[0], f1[0]));

        Stack<Float> stack = new Stack<>();
        int sol = 0;
        float maxTime = -1;
        for(int i=0; i<output.length; i++) {
            if(stack.isEmpty()) {
                stack.push(output[i][1]);maxTime = output[i][1];
            } else {
                float time = maxTime;
                if (time < output[i][1]) {
                    sol++;
                    while(!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                stack.push(output[i][1]);
                maxTime = Float.max(maxTime, output[i][1]);
            }
        }

        if(!stack.isEmpty()) {
            return sol+1;
        }
        return sol;
    }
}
