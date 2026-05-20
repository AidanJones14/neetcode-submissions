class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = -1;
        int right = -1;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target) {
                    left = i;
                    right = j;
                    break;
                }
            }
        }
        return new int[]{left, right};
    }

}
