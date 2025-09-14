#define ll long long
class Solution {
public:
    const int MOD = 1e9+7;

    ll solve(int idx,int oddCnt,int evenCnt,vector<int>& nums,vector<vector<vector<ll>>>&dp){
       if(oddCnt==0 || evenCnt==0){
        return 0;
       }

       if(idx==nums.size()){
        return 1;
       }

       if(dp[idx][oddCnt][evenCnt]!=-1) return dp[idx][oddCnt][evenCnt];

       ll np = solve(idx+1,oddCnt,evenCnt,nums,dp);
       ll p =0;
       if(nums[idx]&1){
        p = solve(idx+1,oddCnt-1,3,nums,dp);
       }else{
        p = solve(idx+1,3,evenCnt-1,nums,dp);
       }

       dp[idx][oddCnt][evenCnt] = (np+p)%MOD;

       return dp[idx][oddCnt][evenCnt];
    }

    int countStableSubsequences(vector<int>& nums) {
       int n = nums.size();
       vector<vector<vector<ll>>>dp(n+1,vector<vector<ll>>(4,vector<ll>(4,-1)));
        
        return (int)solve(0,3,3,nums,dp)-1;
    }
};