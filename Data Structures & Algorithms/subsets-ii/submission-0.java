class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        sol = new ArrayList<>();

        Arrays.sort(nums);
        List<Integer> currentList = new ArrayList<>();
        findSubsets(nums, 0, currentList);

        return sol;
    }

    void findSubsets(int[] nums, int index, List<Integer> currentList) {
        
        if(index == nums.length) {
            sol.add(new ArrayList<>(currentList));
            return;
        }

        int num = nums[index];
        currentList.add(num);
        findSubsets(nums, index+1, currentList);

        currentList.remove(currentList.size()-1);

        int newIndex = index;
        while(newIndex<nums.length && nums[index]==nums[newIndex]) {
            newIndex++;
        }
        findSubsets(nums, newIndex, currentList);
    }
}
