class Solution {
    static int atMostK(int[] nums, int k) {
    int l = 0, r = -1, cnt = 0, ans = 0;

    while (r < nums.length) {
        if (cnt > k) {
            if (nums[l] % 2 == 1) {
                cnt--;
            }
            l++;
        } else {
            ans += (r - l + 1);
            r++;
            if (r < nums.length) {
                if (nums[r] % 2 == 1) {
                    cnt++;
                }
            }
        }
    }

    return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
      int ans =atMostK(nums,k)-atMostK(nums,k-1);
        return ans;
    }

}