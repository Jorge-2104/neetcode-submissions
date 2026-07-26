class Solution {
    public int characterReplacement(String s, int k) {
        
        // init vars
        int[] count = new int[26];
        int left = 0;
        int best = 0;

        // for loop right part of window
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            count[c-'A']++;

            // check if window is valid
                // update biggest window if this is it else leave it (math.max)
            
            // after trying comment above and a little time to refactor:
            // only runs if window is invalid
            while (right-left+1 - getMostFreq(count) > k) {
                count[ s.charAt(left) - 'A' ]--;
                left++;
            }

            // for every valid window
            best = Math.max(best, right-left+1);
        }
        
        return best;            
    }

    public int getMostFreq(int[] count) {
        int mostFreq = 0;
        for (int num : count) {
            mostFreq = Math.max(mostFreq, num);
        }

        return mostFreq;
    }
}
