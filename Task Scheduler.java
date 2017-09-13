class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] ch = new int[26];
        for (char k : tasks) {
            ch[k - 'A']++;
        }
        
        Arrays.sort(ch);//sort to get the char with highest freqency
        int i = 25;
        while(ch[i] == ch[25]) i--; //check how many char share the same highest frequency
        
        return Math.max(tasks.length, (ch[25] - 1) * (n+1) + 25 - i); //c[25] - 1 是chunk出现的数量， n+1是每个chunk的长度， 25 -i是最后的那个高频值，但是如果插满了溢出来了，那么总的长度就和task长度一样了
    }
}
