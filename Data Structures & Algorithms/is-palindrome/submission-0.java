class Solution {
    public boolean isPalindrome(String s) {
        String sClean = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)) sClean += Character.toLowerCase(c);
        }

        int i = 0;
        int j = sClean.length()-1;

        while (i < j) {
            System.out.println(i + j);
            if (sClean.charAt(i) != sClean.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
