class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<>();
        boolean[] check = new boolean[strs.length];
        for(int i = 0; i < strs.length; i ++) {
            if (check[i]) continue;
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            check[i] = true;
            for(int j = i + 1; j < strs.length; j++){
                if(!check[j] && isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    check[j] = true;
                }
            }
            solution.add(group);
        }
        return solution;
    }

    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        HashMap<Character, Integer> compare = new HashMap<>();
        for(int i = 0; i < str1.length(); i ++) {
            char c = str1.charAt(i);
            compare.put(c, compare.getOrDefault(c, 0) + 1);
        }

        for(int j = 0; j < str2.length(); j++){
            char c = str2.charAt(j);
            if(compare.containsKey(c) && compare.get(c) > 0){
                compare.put(c, compare.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
