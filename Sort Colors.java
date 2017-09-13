class Solution {
    public void sortColors(int[] nums) {
        //Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        for (int k = 0; k <= j; k++) {
            if (nums[k] == 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                i++;
            } else if (nums[k] == 2) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                j--;
                k--;
            }
        }
    }
}
