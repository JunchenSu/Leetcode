class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) return false;
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];//把找两个和相同的subset的问题转换为找一个和为总sum的一半的subset的问题
    }
}
