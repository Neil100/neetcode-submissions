class Solution {
    List<List<Integer>> sol;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        sol = new ArrayList<>();
        n = nums.length;
        List<Integer> current = new ArrayList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        findPermutations(current, numsList);
        return sol;
    }

    void findPermutations(List<Integer> current, List<Integer> numsList) {
        if(current.size()==n) {
            sol.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<numsList.size(); i++) {
            current.add(numsList.get(i));
            int taken = numsList.get(i);
            numsList.remove(i);
            findPermutations(current, numsList);

            numsList.add(i, taken);
            current.remove(current.size()-1);
        }
    }
}
