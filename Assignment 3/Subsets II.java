class Solution {
      void solve(int idx,int[] nums,List<Integer>cur,Set<List<Integer>>distinct){
        if(idx==nums.length){
            List<Integer> res = new ArrayList<>();
                for(int val:cur){
                    res.add(val);
                }
            Collections.sort(res);
            if(!distinct.contains(res)){
                
                distinct.add(res);
            }
            return;
        }
        solve(idx+1,nums,cur,distinct);
        cur.add(nums[idx]);

        solve(idx+1,nums,cur,distinct);
        cur.remove(cur.size()-1);

      }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Set<List<Integer>>distinct = new HashSet<>();
        List<Integer> cur = new ArrayList<>();

        solve(0,nums,cur,distinct);

        for(List<Integer> res : distinct){
            ans.add(res);
        }
    

        return ans;
    }
}