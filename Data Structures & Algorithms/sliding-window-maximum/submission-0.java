class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i=0; i<k; i++) {
            pq.add(nums[i]);
        }
        int[] sol = new int[nums.length-k+1];
        int index = 0;
        sol[index++] = pq.peek();
        for(int i=k; i<nums.length; i++) {
            pq.remove(nums[i-(k)]);
            pq.add(nums[i]);
            sol[index++] = pq.peek();
        }

        return sol;
    }
}
