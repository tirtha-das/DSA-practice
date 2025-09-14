class Solution {
    static int solve(int[] nums, int k) {
    int r = -1, l = 0, cnt = 0, ans = 0;

    while (r < nums.length) {
        if (cnt > k) {
            if (nums[l] == 0) {
                cnt--;
            }
            l++;
        } else {
            if (r >= 0) {
                ans = Math.max(ans, (r - l + 1));
            }
            r++;
            if (r < nums.length) {
                if (nums[r] == 0) {
                    cnt++;
                }
            }
        }
    }

    return ans;
    }
    public int longestOnes(int[] nums, int k) {
        return solve(nums,k);
    }
}