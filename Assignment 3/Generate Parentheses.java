class Solution {
    void solve(int idx,int open,int close,StringBuilder sb,List<String> ans){
        if(open==0 && close==0){
            ans.add(sb.toString());
            return;
        }

        if(open>0){
            sb.setCharAt(idx,'(');
            solve(idx+1,open-1,close,sb,ans);
            sb.setCharAt(idx,'a');
        }

        if(close>open){
            sb.setCharAt(idx,')');
            solve(idx+1,open,close-1,sb,ans);
            sb.setCharAt(idx,'a');
        }
    }

    public List<String> generateParenthesis(int n) {

        StringBuilder sb = new StringBuilder("a".repeat(2*n));
        List<String> ans = new ArrayList<>();

        solve(0,n,n,sb,ans);

        return ans;
    }
}