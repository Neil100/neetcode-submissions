class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sol = new ArrayList<>();
        List<Integer> currentComb = new ArrayList<>();
        Arrays.sort(candidates);
        createCombination(candidates, target, 0, currentComb);
        return sol;
    }

    void createCombination(int[] candidates, int target, int index, List<Integer> currentComb) {
        if(target == 0) {
            sol.add(new ArrayList<>(currentComb));
            return;
        }

        if(index>=candidates.length) {
            return;
        }
        if(target<candidates[index])
            return;

        int i = index;
        // for(int i=index; i<candidates.length; i++) {
            int candidate = candidates[i];

            currentComb.add(candidate);
            int newIndex = index+1;
            while(newIndex<candidates.length && candidates[newIndex]==candidates[i]) {
                newIndex++;
            }
            createCombination(candidates, target-candidate, index+1, currentComb);

            currentComb.remove(currentComb.size()-1);

            createCombination(candidates, target, newIndex, currentComb);
        // }
    }
}
