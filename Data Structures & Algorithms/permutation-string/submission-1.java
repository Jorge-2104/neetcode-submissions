class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false; // forgot this line but after running and seeing whats wrong VERY quick fix
        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need[c-'a']++;

            char c2 = s2.charAt(i);
            window[c2-'a']++;
        }

        if (isSub(need, window)) return true;

        for (int right = s1.length(); right < s2.length(); right++) {
            int prevLeft = right-s1.length();
            window[s2.charAt(prevLeft)-'a']--;

            window[s2.charAt(right)-'a']++; // forgot -'a' here and above extremely quick fix wouldnt count it as an error

            if (isSub(need, window)) return true;
        }

        return false;
    }

    public boolean isSub(int[] need, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (window[i] < need[i]) return false;
        }

        return true;
    }
}
