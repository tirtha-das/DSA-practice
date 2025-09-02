class Solution {
    static void find(int remain, int[] nums, List<Integer> cur, int[] visited, Set<List<Integer>> ans) {
    if (remain == 0) {
        List<Integer> res = new ArrayList<>();
        for (int val : cur) {
            res.add(val);
        }
        ans.add(res);
        return;
    }
    for (int idx = 0; idx < nums.length; idx++) {
        if (visited[idx] == 0) {
            cur.add(nums[idx]);
            visited[idx] = 1;
            find(remain - 1, nums, cur, visited, ans);
            visited[idx] = 0;
            cur.remove(cur.size() - 1);
        }
    }
}

static List<List<Integer>> solve(int[] nums) {
    Set<List<Integer>> ans = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    int len = nums.length;
    List<Integer> cur = new ArrayList<>();
    int[] visited = new int[len];
    find(len, nums, cur, visited, ans);
    for (List<Integer> temp : ans) {
        res.add(temp);
    }
    return res;
}
    public List<List<Integer>> permuteUnique(int[] nums) {
        return solve(nums);
            }
}