class Solution {
    public int longestConsecutive(int[] nums) {
        // Store every number for O(1) lookup
        // Only start counting if this number is the start of a sequence
        // Count upward from the start
        // Update longest
        // Return longest

        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longestSequence = 1;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (!set.contains(current-1)) {
                int currentSequence = 1;
                while (true) {
                    if (set.contains(current+1)) {
                        currentSequence++;
                        current++;
                    }
                    else {
                        if (longestSequence < currentSequence) {
                            longestSequence = currentSequence;
                        }
                        break;
                    }
                }
            }
        }

        return longestSequence;
    }

}
