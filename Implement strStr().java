public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle) || needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        if(needle == null || haystack == null) return -1;
        int i = 0, j = 0;
        int startpoint;
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        while(i <= a.length - b.length) {
            if(a[i] == b[j]) {
                startpoint = i;
                while(j<b.length && a[i] == b[j]) {
                    i++;
                    j++;
                }
                if(j == b.length) return startpoint;
                else{
                    i = startpoint;
                    j = 0;
                }
            }
            i++;
        }
        return -1;
    }
}
