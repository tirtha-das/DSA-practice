// User function Template for Java

class Solution {
    public int TotalPairs(int[] nums, int k) {
        // Code here
        Arrays.sort(nums);
        
        int l = 0,cnt=0;
        int r = l+1;
        while(l<nums.length){
            if(r<=l){
                r=l+1;
            }
            if(r>=nums.length){
                break;
            }
            
            if(nums[l]+k==nums[r]){
               // System.out.println(l+" "+r+" "+nums[l]+" "+nums[r]);
                cnt++;
                l++;
                while(l<nums.length && nums[l-1]==nums[l]){
                    l++;
                }
               
            }else if(nums[l]+k>nums[r]){
                r++;
            }else{
                l++;
            }
        }
        
        return cnt;
        
        
    }
}