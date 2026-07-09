class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int total = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while (left <= right) {
            if (maxLeft <= maxRight) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                }
                else {
                    total += maxLeft - height[left];
                }

                left++;
            }
            else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                }
                else {
                    total += maxRight - height[right];
                }

                right--;
            }
        }

        return total;
    }
}
