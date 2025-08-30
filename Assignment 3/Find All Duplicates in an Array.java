class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans  = new ArrayList<Integer>();

        for(int val : nums){
            int idx = Math.abs(val)-1;
            if(nums[idx]<0){
                ans.add(idx+1);
            }else{
                nums[idx]*=(-1);
            }
            
        }
       // to retrive the original input array 
       //Because manipulating original array is not a good practice
        for(int i = 0;i<nums.length;i++){
            nums[i] = Math.abs(nums[i]);
        }

        return ans;
    }
}