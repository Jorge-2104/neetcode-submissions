class Solution {
    // at 25 min this was my first run, no mistakes other than the divide by 0 and the runtime error somewhere
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
            int mid = left + (right - left) / 2;
            int k = mid;

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
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        // return the min k
        return bestK;
    }
}
