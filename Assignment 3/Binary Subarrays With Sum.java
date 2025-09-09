class Solution {
    static int countTarget(int[] nums, int target) {
    if (target < 0) {
        return 0;
    }

    int l = 0, r = -1, cnt = 0, sum = 0;

    while (r < nums.length) {
        if (sum > target) {
            sum -= nums[l];
            l++;
        } else {
            if (r >= 0) {
                cnt += (r - l + 1);
            }
            r++;
            if (r < nums.length) {
                sum += nums[r];
            }
        }
    }

    return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countTarget(nums,goal)-countTarget(nums,goal-1);
    }
}