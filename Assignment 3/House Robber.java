
public class Solution {

	public static int maxMoneyLooted(int[] nums) {
		int n = nums.length;
        // int[] dp = new int[n+1];
        // dp[n] = 0;
        int prev1 = 0;
        int prev2 = 0;

        for(int idx=n-1;idx>=0;idx--){
            // int notPick = prev1;
            // int pick = nums[idx]+(idx+2<=n ? prev2:0);

           int cur = Math.max(prev1,nums[idx]+(idx+2<=n ? prev2:0));
           prev2 = prev1;
           prev1 = cur;
        }

       return prev1;
	}
}