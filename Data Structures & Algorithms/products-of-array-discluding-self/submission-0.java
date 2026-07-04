class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        product[n-1] = nums[n-1];
        for(int i=n-2; i>=1; i--) {
            product[i] = nums[i]*product[i+1];
        }
        int rightProduct = 1;
        for(int i=0; i<n-1; i++) {
            product[i] = rightProduct*product[i+1];
            rightProduct = rightProduct*nums[i]; 
        }
        product[n-1] = rightProduct;

        return product;
    }
}  
