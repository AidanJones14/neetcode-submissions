class Solution {

    public String encode(List<String> strs) {
        StringBuilder payload = new StringBuilder();
        for(String s : strs) {
            s = s.replace("\\", "\\\\");
            s = s.replace("#", "\\#");
            s+="#";
            payload.append(s);
        }

        return payload.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList();
        List<Integer> indexes = new ArrayList();
        indexes.add(0);
        StringBuilder clean = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '\\' && (i + 1) < str.length()) {
                clean.append(str.charAt(i + 1));
                i += 1;
            } else if(str.charAt(i) == '#') {
                indexes.add(clean.length());
            } else {
                clean.append(str.charAt(i));
            }
        }
        String cleaned = clean.toString();
        for(int k = 0; k < indexes.size() - 1; k++) {
            decoded.add(cleaned.substring(indexes.get(k), indexes.get(k + 1)));
        }

        return decoded;
    }
}
