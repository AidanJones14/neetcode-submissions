class Solution {
    public int lengthOfLongestSubstring(String s) {
        var map = new HashMap<Character, Integer>();
        int left = 0, right = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(i - map.get(s.charAt(i)) <= (right - left + 1)) {
                    left = map.get(s.charAt(i)) + 1;
                    right = i;
                    map.put(s.charAt(i), i); 
                } else {
                    right = i;
                    map.put(s.charAt(i), i); 
                }
            } else {
                right = i;
                map.put(s.charAt(i), i);
            }
            max = (right - left + 1) > max ? (right - left + 1) : max;
        }
        return max;
    }
}
