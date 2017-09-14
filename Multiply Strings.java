class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
   
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;//第i位和第j位乘起来的结果放在第i+j位和i+j+1位，因为都是个位数相乘，所以乘的结果都是2位，个位放i+j+1位，十位放i+j位
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;//十位放到下一位当进位
                pos[p2] = (sum) % 10;//个位加上上一次相乘的进位
            }
        }  
    
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
        //长度为a的数和长度为b的数相乘结果是a+b的数，最高位是产生的进位。
    }
}

               
