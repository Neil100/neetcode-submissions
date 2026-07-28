class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        sol = new ArrayList<>();
        List<Integer> currentComb = new ArrayList<>();
        gatherCombinations(nums, 0, target, currentComb);
        return sol;
    }

    void gatherCombinations(int[] nums, int index, int target, List<Integer> currentComb) {

        if(index == nums.length)
            return;

        gatherCombinations(nums, index+1, target, currentComb);

        int num = nums[index];
        int newTarget = target-num;
        currentComb.add(num);
        if(newTarget==0) {
            sol.add(new ArrayList<>(currentComb));
        } else if(newTarget>0) {
            gatherCombinations(nums, index, newTarget, currentComb);
        }

        currentComb.remove(currentComb.size()-1);
    }
}
