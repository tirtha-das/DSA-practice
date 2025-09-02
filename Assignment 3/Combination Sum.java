    static void find(int idx, int[] candidates, int num, List<Integer> cur, Set<List<Integer>> ans) {
    if (num < 0 || idx == candidates.length) {
        return;
    } else if (num == 0) {
        List<Integer> res = new ArrayList<>();
        for (int val : cur) {
            res.add(val);
        }
        ans.add(res);
        return;
    }
    find(idx + 1, candidates, num, cur, ans);
    for (; idx < candidates.length; idx++) {
        cur.add(candidates[idx]);
        find(idx, candidates, num - candidates[idx], cur, ans);
        cur.remove(cur.size() - 1);
    }
}

static List<List<Integer>> solve(int[] candidates, int n) {
    Set<List<Integer>> ans = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    int lowest = candidates[0];
    for (int i : candidates) {
        lowest = Math.min(lowest, i);
    }
    if (lowest > n) return res;
    List<Integer> cur = new ArrayList<>();
    find(0, candidates, n, cur, ans);
    for (List<Integer> temp : ans) {
        res.add(temp);
    }
    return res;
}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return solve(candidates, target);
    }
}