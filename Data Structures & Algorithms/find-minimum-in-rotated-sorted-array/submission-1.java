class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length;
        int a = nums[0], b = nums[r-1];
        while(l<r) {
            int mid = (r-l) / 2 + l;

            if(nums[mid] < a) {
                r = mid;
            } else {
                l = mid+1;
            }
        }

        return r>nums.length-1 ? nums[0] : nums[r];
    }
}
