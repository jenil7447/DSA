class Solution {
    public int maxProduct(int[] nums) {
        int product = 1; 
        int max = nums[0];
        for(int i = 0 ; i < nums.length ; i ++){
            if(max < nums[i]){
                max = nums[i];

            }
        }
        for(int i = 0 ; i < nums.length ; i ++){
            for(int j = i; j < nums.length ; j++){
            product = product * nums[j];
            if(max < product){
                max = product;
            }
            }
            product = 1;
        }
        return max;
    }
}

