class Solution {
    public int trap(int[] height) {
        int[] maxHeight = new int[height.length];
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[i] > leftMax) {
                leftMax = height[i];
            }
            maxHeight[i] = leftMax;
        }

        for(int i = height.length - 1; i >= 0; i--) {
            if(height[i] > rightMax) {
                rightMax = height[i];
            }
            maxHeight[i] = maxHeight[i] > rightMax ? rightMax : maxHeight[i];
        }
        int solution = 0;
        for(int i = 0; i < height.length; i++) {
            int check = maxHeight[i] - height[i];
            solution += check < 0 ? 0 : check;
        }
        return solution;
    }
}
