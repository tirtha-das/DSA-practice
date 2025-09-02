class Solution {
    static void find(int idx, int limit, int num, int prev,
                 List<Integer> cur, List<List<Integer>> ans) {
    if (num < 0) return;
    if (idx == limit) {
        if (num == 0) ans.add(new ArrayList<>(cur));
        return;
    }
    for (int val = prev + 1; val <= 9; val++) {
        cur.set(idx, val);
        find(idx + 1, limit, num - val, val, cur, ans);
    }
}

static List<List<Integer>> solve(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    int lowest = (k + 1) * k / 2;
    if (lowest > n) return ans;
    List<Integer> cur = new ArrayList<>();
    for (int i = 0; i < k; i++) cur.add(-1);
    find(0, k, n, 0, cur, ans);
    return ans;
}
    public List<List<Integer>> combinationSum3(int k, int n) {
        return solve(k,n);
            
            }
}