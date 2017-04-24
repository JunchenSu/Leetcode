public class Solution {
    public boolean checkRecord(String s) {
        int late = 0;
        int absent = 0;
        int flag = 0;
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i) == 'L') {
                if(flag == 2) return false;
                else flag ++;
                continue;
            }
            if(s.charAt(i) == 'A') absent++;
            if(absent == 2) return false;
            flag = 0;
        }
        return true;
    }
}
