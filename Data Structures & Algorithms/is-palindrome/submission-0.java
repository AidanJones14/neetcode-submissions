class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                build.append(c);
            }
        }
        String compressed = build.toString();
        int lastIndex = compressed.length() - 1;
        for(int i = 0; i < compressed.length(); i++) {
            if(compressed.charAt(i) != compressed.charAt(lastIndex - i)) {
                return false;
            }
        }
        return true;
    }
}
