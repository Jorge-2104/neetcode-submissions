class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }

        int maxFreq = 0;
        for (int num : map.keySet()) {
            int curFreq = map.get(num);
            if (curFreq > maxFreq) maxFreq = curFreq;
        }

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxFreq; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : map.keySet()) {
            int curFreq = map.get(num);
            buckets.get(curFreq).add(num);
        }

        ArrayList<Integer> firstK = new ArrayList<>();
        for (int i = maxFreq; i > 0 && firstK.size() < k; i--) {
            ArrayList<Integer> current = buckets.get(i);

            for (int j = 0; j < current.size() && firstK.size() < k; j++) {
                int num = current.get(j);
                firstK.add(num);
            }
        }
        
        int[] result = new int[firstK.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = firstK.get(i);
        }

        return result;
    }
}
