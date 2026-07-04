class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> sol = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            int target = nums[i]*-1;

            int l=i+1, r=nums.length-1;
            while(l<r) {
                int sum = nums[l]+nums[r];

                if(sum>target) {
                    r--;
                } else if(sum<target) {
                    l++;
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    set.add(list);
                    r--;
                    l++;
                }
            }
        }

        return set.stream().toList();
    }
}
