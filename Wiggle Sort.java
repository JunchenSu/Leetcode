public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        Arrays.sort(nums);
        int i = 2;
        while (i<nums.length) {
            swap(nums,i,i-1);
            i+=2;
        }
        return;
    }
    
    private void swap(int[] nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
