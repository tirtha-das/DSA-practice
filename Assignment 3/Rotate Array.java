class Solution {
      void rotate(int start,int end,int[]nums){
        while(start<end){
            nums[start] += nums[end];
            nums[end] = nums[start]-nums[end];
            nums[start] = nums[start]-nums[end];
            start++;
            end--;
        }
      }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
         k = k%n;
         rotate(0,n-k-1,nums);
         rotate(n-k,n-1,nums);
         rotate(0,n-1,nums);
    }
}