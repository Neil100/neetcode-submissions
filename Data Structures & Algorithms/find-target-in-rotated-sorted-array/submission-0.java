class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        int a = nums[0], b = nums[r-1];
        while(l<r) {
            int mid = (r-l)/2 + l;
            if(nums[mid] < a) {
                r = mid;
            } else {
                l = mid+1;
            }
        }

        // if(r==nums.length)
        //     r = 0;
        int left, right;
        if(target>=nums[0]) {
            left = 0; right = r-1;

        } else {
            left = r; right = nums.length-1;
        }

        while(left<=right) {
            int mid = (right-left)/2 + left;
            if(nums[mid] < target) {
                left = mid+1;
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
