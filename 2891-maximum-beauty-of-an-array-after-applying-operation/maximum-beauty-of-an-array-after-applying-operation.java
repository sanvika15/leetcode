class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int answer = 0 ; 
        
        Arrays.sort(nums) ;
        
        for (int left = 0 , right = 0 ; right <nums.length ; right ++){
            while(nums[right] - nums[left] >2*k)
                left++;
            answer = Math.max(answer , right-left+1);
        }
        return answer;
    }
}