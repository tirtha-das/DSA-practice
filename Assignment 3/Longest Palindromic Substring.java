class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("*");

        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append("*");
        }

        int len = sb.length();
       int[] dp = new int[len];
       int ans = 1;
       int resIdx = 1;

        for(int i=0;i<len;i++){
            int left = i,right = i;
            while(left>=0 && right<len){
                if(sb.charAt(left)!=sb.charAt(right)){
                    break;
                }

                left--;
                right++;
            }
            dp[i] = (i-left-1);

            if(dp[i]>ans){
              ans = dp[i];
              resIdx = i;
            }
        }

        int l = resIdx,r=resIdx;
        StringBuilder forword=new StringBuilder("");
        StringBuilder backword=new StringBuilder("");

        int temp = dp[resIdx];
        
        while(temp>0){
            if(sb.charAt(r)!='*'){
                forword.append(sb.charAt(r));
            }
            if(l!=resIdx && sb.charAt(l)!='*'){
                backword.append(sb.charAt(l));
            }

            temp--;
            r++;
            l--;
        } 

        backword.reverse();
        backword.append(forword);
        return backword.toString();
    }
}