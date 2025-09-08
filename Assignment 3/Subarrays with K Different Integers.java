class Solution {
    static int atMostK(int[] nums, int k) {
    if (k == 0) {
        return 0;
    }
    Map<Integer, Integer> mp = new HashMap<>();
    int l = 0, r = -1, cnt = 0, ans = 0;
    while (r < nums.length) {
        if (cnt > k) {
            int val = nums[l];
            int freq = mp.get(val);
            mp.put(val, freq - 1);
            if (freq == 1) {
                cnt--;
            }
            l++;
        } else {
            if (r>=0) {
                ans += r - l + 1;
            }
            r++;
            if (r < nums.length) {
                int val = nums[r];
                int freq = mp.containsKey(val) ? mp.get(val) : 0;
                mp.put(val, freq + 1);
                if (freq == 0) {
                    cnt++;
                }
            }
            
        }
    }
    return ans;
}

static int solve(int[] nums, int k) {
    int ans = atMostK(nums, k);
    int res = atMostK(nums, k - 1);
    return ans - res;
}
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k);
    }
}