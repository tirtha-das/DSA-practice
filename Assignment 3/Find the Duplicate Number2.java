class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++){
            
                while(nums[i]!=i+1){
                    int idx = nums[i]-1;
                    if(nums[idx]==nums[i]){
                        return nums[idx];
                    }

                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                }
            
        }

        return -1;
    }
}