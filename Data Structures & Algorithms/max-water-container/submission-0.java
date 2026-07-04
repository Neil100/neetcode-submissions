class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length-1;
        int sol = 0;
        while(l<r) {
            if(heights[r]>=heights[l]) {
                sol = Integer.max(sol, (r-l)*(heights[l]));
                l++;
            } else {
                sol = Integer.max(sol, (r-l)*(heights[r]));
                r--;
            }
        }
        return sol;
    }
}
