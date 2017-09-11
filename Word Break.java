class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        Set<String> set = new HashSet<>();
        for (String i : wordDict) {
            set.add(i);
        }
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && set.contains(s.substring(j,i))) res[i] = true;
            }
        }
        return res[s.length()];
    }
}
