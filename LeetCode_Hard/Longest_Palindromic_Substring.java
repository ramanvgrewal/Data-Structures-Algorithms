class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            int r = i;
            int l = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > maxLen) {
                    ans = s.substring(l, r + 1);
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }

            r = i + 1;
            l = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > maxLen) {
                    ans = s.substring(l, r + 1);
                    maxLen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}