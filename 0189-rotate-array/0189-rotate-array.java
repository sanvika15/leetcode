class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        reverse(nums, start + 1, end - 1);
    }
}