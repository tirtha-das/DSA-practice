class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer>ans = new ArrayList<>();

        int i=nums.length-1;
        while(i>=0){
            ans.add(nums[i]);
            k--;
            if(k==0){
                break;
            }
            while(i-1>=0 && nums[i-1]==nums[i]){
                i--;
            }
            i--;
        }

        int[]res = new int[ans.size()];

        for(int j=0;j<ans.size();j++){
            res[j] = ans.get(j);
        }

        return res;
    }
}