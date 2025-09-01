class Solution {
    int solve(int idx,char[] s){
        if(s.length==idx){
            return 0;
        }

        char ch = s[idx];
        int newIdx = solve(idx+1,s);

        s[newIdx++] = ch;

        return newIdx;
    }

    public void reverseString(char[] s) {
        solve(0,s);
    }
}