class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        int[] sol = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(set.containsKey(nums[i])) {
                // sol[0] = set.get(nums[i]);
                // sol[1] = i;
                // return sol;
                return new int[]{set.get(nums[i]), i};
            }

            set.put(target-nums[i], i);
        }

        return sol;
    }
}
