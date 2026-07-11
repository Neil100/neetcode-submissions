class Solution {
    public int findDuplicate(int[] nums) {
        int withModNumber = 100000;
        for(int i=0; i<nums.length; i++) {
            int num = nums[i]%(100000);

            if(nums[num]>10000) {
                return num;
            } else {
                nums[num] = nums[num] + 100000;
            }
        }

        return 0;
    }
}
