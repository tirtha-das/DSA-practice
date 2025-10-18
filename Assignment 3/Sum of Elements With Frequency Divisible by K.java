class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        Map<Integer,Integer>mp = new HashMap<>();

        for(int val:nums){
            mp.put(val,mp.getOrDefault(val,0)+1);
        }

        int sum = 0;
         for(int val:nums){
            if(mp.get(val)%k==0){
                sum+=val;
            }
        }

        return sum;
    }
}