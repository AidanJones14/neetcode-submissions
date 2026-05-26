class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for(int i = 1; i < nums.length; i++) {
            
            prefix[i] = nums[i - 1] * prefix[i - 1];

        }
        for(int j = nums.length - 2; j >= 0; j--) {
            suffix[j] = nums[j + 1] * suffix[j + 1];
        }
        for(int k = 0; k < nums.length; k++) {
            solution[k] = prefix[k] * suffix[k];
        }

        return solution;
    }
}