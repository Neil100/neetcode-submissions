class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> subsets(int[] nums) {
        sol = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        createSubset(nums, 0, currentList);
        return sol;
    }

    void createSubset(int[] nums, int index, List<Integer> currentList) {

        if(index==nums.length) {
            sol.add(new ArrayList<>(currentList));
            return;
        }

        createSubset(nums, index+1, currentList);
        currentList.add(nums[index]);
        createSubset(nums, index+1, currentList);
        currentList.remove(currentList.size()-1);
    }
}
