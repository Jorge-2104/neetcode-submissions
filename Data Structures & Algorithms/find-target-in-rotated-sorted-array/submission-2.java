class Solution {
    public int search(int[] nums, int target) {
        // find the min
        int left = 0;
        int right = nums.length-1; // needed -1

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }

        int minIdx = left;

        // check which half target should be in and set the bounds
        if (nums[minIdx] <= target && target <= nums[nums.length-1]) { // tried to do <= target <= first run had to split it up with &&, needed -1 for the last bound
            left = minIdx;
            right = nums.length-1;
        }
        else {
            left = 0;
            right = minIdx - 1;
        }

        // bin search that range
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }

        return -1;
    }
}