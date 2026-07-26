class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // init
        String bestSub = "";
        int bestLen = Integer.MAX_VALUE;
        int[] count = new int[128];
        int left = 0;

        // sub for each needed in the window
        for (char c : t.toCharArray()) {
            count[c]--;
        }

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            count[c]++;

            while (isSub(count)) {
                String sub = s.substring(left, right+1);


                // took a couple mins to find
                if (sub.length() < bestLen) {
                    bestSub = sub;
                    bestLen = sub.length();
                }
                

                count[s.charAt(left)]--;
                left++;
            }
        }

        return bestSub;
    }

    // subtracted from counts in beginning for what we need, after going through if count is >= 0 for all that means the sub is in there
    public boolean isSub(int[] count) {
        for (int num : count) {
            if (num < 0) return false; // found this instantly after first run, actually i had it right the first time whoops
        }

        return true;
    }
}
