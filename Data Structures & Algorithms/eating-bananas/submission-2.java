class Solution {
    // at 29 min this was my second run and passed, also cleaned up some memory stuff after i knew i passed
    public int minEatingSpeed(int[] piles, int h) {
        // find the biggest pile O(n)
        int right = -1;
        for (int num : piles) {
            if (num > right) right = num;
        }

        // bin search for min k
        int left = 1;
        int bestK = right;

        while (left <= right) {
            int k = left + (right - left) / 2;

            // calculate how many hours at mid it takes to eat all the bananas in piles
            int total = 0;
            for (int pile : piles) {
                total += pile / k;

                if (pile % k != 0) total++;
            }

            // if its under h we keep it and keep looking
            // if its over h we get rid of it
            if (total <= h) {
                bestK = k;
                right = k - 1;
            }
            else {
                left = k + 1;
            }
        }

        // return the min k
        return bestK;
    }
}
