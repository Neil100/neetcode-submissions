class Solution {

    Set<Integer> set;
    public int longestConsecutive(int[] nums) {
        
        set = new HashSet<Integer>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int sol = 0;

        for(int num: nums) {
            int tempLength = smallerNumberLength(num-1) + greaterNumberLength(num+1) + 1;

            sol = Integer.max(sol, tempLength);
        }

        return sol;
    }

    int smallerNumberLength(int num) {
        if(set.contains(num)) {
            set.remove(num);
            return 1 + smallerNumberLength(num-1);
        }
        return 0;
    }

    int greaterNumberLength(int num) {
        if(set.contains(num)) {
            set.remove(num);
            return 1 + greaterNumberLength(num+1);
        }
        return 0;
    }
}
