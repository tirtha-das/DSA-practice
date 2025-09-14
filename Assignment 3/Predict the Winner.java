class Solution {
    static int solve(int left, int right, int[] nums) {
    if (left == right) {
        return nums[left];
    }
        
   
        int leftans = nums[left]-solve(left + 1, right, nums);
        int rightans = nums[right]-solve(left, right - 1, nums);
    
    
    return Math.max(leftans,rightans);
    }
    public boolean predictTheWinner(int[] nums) {
        return solve(0,nums.length-1,nums)>=0;
    }
}