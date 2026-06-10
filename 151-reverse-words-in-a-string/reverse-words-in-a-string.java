class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        String word = "";
        String ans = "";

        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);

            if (ch == ' ') {
                if (!word.isEmpty()) {
                    if (ans.isEmpty())
                        ans = word;
                    else
                        ans = word + " " + ans;
                    word = "";
                }
            } else {
                word += ch;
            }
        }

        // Add the last word
        if (!word.isEmpty()) {
            if (ans.isEmpty())
                ans = word;
            else
                ans = word + " " + ans;
        }

        return ans;
    }
}