class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); //向右移动一位相当于除二
        //这部分的作用是将原问题转化为找一个subset， 这个subset的二倍等于S+sum，所以锁定了S+sum必须是个偶数
    }   

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;//因为所有数都是非负数，所以subset sum 等于0只有一种可能就是这个subset为空
        for (int n : nums)
            for (int i = s; i >= n; i--)//这里必须从尾开始，否则的话会一直叠加，画一个2维数组看一下就知道了，和subset sum那题很像
                dp[i] += dp[i - n]; //在二维数组里，这句话其实相当于dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
        return dp[s];
    } 
}
