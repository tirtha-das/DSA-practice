class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int cnt = 0,sum = 0;
        mp.put(0,1);

        for(var val : nums){
          sum += val;
          if(mp.containsKey(sum-k)){
            cnt += mp.get(sum-k);
          }

          int freq = (mp.containsKey(sum))?mp.get(sum):0;
          mp.put(sum,freq+1);
        }

        return cnt;


    }
}