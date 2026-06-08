class Solution {

    public String encode(List<String> strs) {
        String encoded = "";

        for (String word : strs) {
            encoded += word.length() + "#" + word;
        }

        return encoded;
    }

    public List<String> decode(String str) {
        List<String> words = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            
            int j = i;
            while (str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            String word = str.substring(start, start + len);
            words.add(word);

            i = start + len;
        }

        return words;

    }
}
