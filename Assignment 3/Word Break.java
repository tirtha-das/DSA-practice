class Solution {
    static int isPossible(int idx, String s, Set<String> present, int[] dp) {
    if (idx == s.length()) {
        return 1;
    }
    if (dp[idx] != -1) return dp[idx];
    StringBuilder cur = new StringBuilder();
    int ans = 0;
    for (int i = idx; i < s.length(); i++) {
        cur.append(s.charAt(i));
        if (present.contains(cur.toString())) {
            ans += isPossible(i + 1, s, present, dp);
            if (ans > 0) break;
        }
    }
    return dp[idx] = ans;
}

static boolean solve(String s, List<String> wordDict) {
    int len = s.length();
    int[] dp = new int[len + 1];
    Arrays.fill(dp, -1);
    Set<String> present = new HashSet<>(wordDict);
    return isPossible(0, s, present, dp) > 0;
}
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s,wordDict);
    }
}