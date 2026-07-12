class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        int minIdx = left;

        if (nums[left] <= target && target <= nums[nums.length-1]) {
            left = minIdx;
            right = nums.length-1;
        }
        else {
            left = 0;
            right = minIdx - 1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }

        return -1;
    }
}
