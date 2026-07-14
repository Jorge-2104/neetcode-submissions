class TimeMap {
    public class Entry {
        public int timestamp;
        public String value;

        public Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private HashMap<String, ArrayList<Entry>> stores;

    public TimeMap() {
        stores = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!stores.containsKey(key)) stores.put(key, new ArrayList<>());

        stores.get(key).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!stores.containsKey(key)) return "";

        ArrayList<Entry> list = stores.get(key);

        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = left + (right - left) / 2;
            int current = list.get(mid).timestamp;

            if (current <= timestamp) left = mid + 1;
            else right = mid;
        }

        left--;

        if (left < 0) return "";

        return list.get(left).value;
    }
}
