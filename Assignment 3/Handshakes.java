// User function Template for Java

class Solution {
    static int solve(int n){
        if(n==0 || n==2) return 1;
       // if(n%2==1) return 0;
        int ans = 0;
        for(int i=0;i<=n-2;i+=2){
           int left = solve(i);
           int right = solve(n-2-i);
           
           ans += (left*right);
        }
        
        return ans;
    }
    
    static int count(int N) {
        // code here
        return solve(N);
    }
};