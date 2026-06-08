class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = getArea(heights, left, right);
        while(left < right) {
            if(heights[left] < heights[right]) {
                left += 1;
                int area = getArea(heights, left, right);
                if(area > max) {
                    max = area;
                }
            } else {
                right -= 1;
                int area = getArea(heights, left, right);
                if(area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    private int getArea(int[] heights, int l, int r) {
        return (r - l) * Math.min(heights[l], heights[r]);
    }
}
