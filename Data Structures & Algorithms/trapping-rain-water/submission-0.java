class Solution {
    public int trap(int[] height) {
        int maxIndex=0, maxValue = Integer.MIN_VALUE;

        for(int i=0; i<height.length; i++) {
            if(height[i]>maxValue) {
                maxValue = height[i];
                maxIndex = i;
            }
        }
        int leftMax = 0;
        int sol = 0;
        for(int i=0; i<maxIndex;i++) {
            if(leftMax>height[i]) {
                sol = sol + leftMax - height[i];
            } else {
                leftMax = height[i];
            }
        }
        int rightMax=0;
        for(int i=height.length-1; i>maxIndex; i--) {
            if(rightMax>height[i]) {
                sol = sol + rightMax - height[i];
            } else {
                rightMax = height[i];
            }
        }

        return sol;
    }
}
