class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0,cnt2=0,ele1 = (int)(1e9+7), ele2 = (int)(1e9+1);

        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && nums[i]!=ele2){
                cnt1=1;
                ele1 = nums[i];
            }else if(cnt2==0 && nums[i]!=ele1){
                cnt2=1;
                ele2 = nums[i];
            }else if(ele1==nums[i]){
                cnt1++;
            }else if(ele2 == nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2=0;

        for(int val : nums){
            if(ele1==val){
                cnt1++;
            }else if(ele2==val){
                cnt2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if(cnt1>(nums.length/3)) ans.add(ele1);
        if(cnt2>(nums.length/3)) ans.add(ele2);
      return ans;
    }
}