class Solution {
public:
    int minOperations(string s) {
        
        char ch = 'z';
        int check = 0;
        for(int i=0;i<s.size();i++){
            if(s[i]!='a' && s[i]<=ch){
                ch = s[i];
                check = 1;
            }
        }
         if(check==0){
             return 0;
         }
        int val = ch - 'a';
        int ans = (26-val)%26;

        return ans;
    }
};