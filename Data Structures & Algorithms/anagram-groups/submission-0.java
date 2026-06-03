class Solution {
    public static String anagramKey(String word) {
            int[] count = new int[26];

            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i)-'a']++;
            }

            String key = "";
            for (int i = 0; i < 26; i++) {
                key += "#" + count[i];
            }

            return key;
        }

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String word : strs) {
            String key = anagramKey(word);
            if (!map.containsKey(key)) { 
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            }
            else {
                ArrayList<String> list = map.get(key);
                list.add(word);
                map.put(key, list);
            }
        }

        List<List<String>> anagrams = new ArrayList<>();
        for (String key : map.keySet()) {
            anagrams.add(map.get(key));
        }

        return anagrams;
    }
}