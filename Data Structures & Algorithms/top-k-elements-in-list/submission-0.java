class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Sorting
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> numberToFrequency = new ArrayList<>();
        int currentNumber = nums[0];
        int counter = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]!=nums[i-1]) {
                List<Integer> list = new ArrayList<>();
                list.add(counter);
                list.add(currentNumber);
                counter = 1;
                currentNumber = nums[i];
                numberToFrequency.add(list);
            } else {
                counter++;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(counter);
        list.add(currentNumber);
        
        numberToFrequency.add(list);

        numberToFrequency.sort(Comparator.comparingInt(l -> l.get(0)));
        int[] sol = new int[k];
        int j = 0;
        for(int i=numberToFrequency.size()-1; i>=0 && j!=k; i--) {
            sol[j++] = numberToFrequency.get(i).get(1);
        }
        return sol;
    }

    // public int[] topKFrequent(int[] nums, int k) {
        
    // }
}
