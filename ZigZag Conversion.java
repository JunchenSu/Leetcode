public class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++) {
            sb[i] = new StringBuffer();
        }
        int idx = 0;//used to mark the row
        int i = 0;
        while(i < len) {
            for(idx = 0; i < len && idx < numRows; idx++, i++) {
                sb[idx].append(c[i]);
            }
            
            for( idx = numRows - 2; i < len && idx >= 1; idx--,i++) {
                sb[idx].append(c[i]);
             }
       }
       for (idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
       return sb[0].toString();
    }      
}
