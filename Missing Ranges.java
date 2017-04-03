public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new ArrayList<>();
        
        long pre = (long)lower - 1;//用lower-1表示从负无穷到lower-1这个range，用upper+1表示upper+1到正无穷这个range
        
        for (int i = 0; i <= nums.length; ++i){//进循环的时候，要让它循环length+1次，第一次用来检查lower到nums[0]之间是不是有Missing range，最后一次用来检查upper到nums[length-1]是不是有missing range
            long next = (i == nums.length) ? (long)upper + 1 : (long)nums[i];
            if (pre + 1 <= next - 1) {//这里比价的时候是用pre+1和next-1比较，所以这也是为什么设定lower-1和upper+1
                if (pre + 1 == next - 1) ret.add(String.valueOf(pre + 1));
                else ret.add(String.valueOf(pre + 1) + "->" + String.valueOf(next - 1));
            }
            pre = next;
        }
        
        return ret;
    }
} 
