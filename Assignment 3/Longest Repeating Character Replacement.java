class Solution {
    static int solve(String s, int k){

    int r = -1, l = 0;

    int ans = 1;
    int maxFreq = 0;

    Map<Character, Integer> freq = new HashMap<>();

    while(r < s.length()){

        

        if(r >= 0){

            int len = (r - l + 1) - maxFreq;

            if(len <= k){

                ans = Math.max(r - l + 1, ans);

            } else {

                char leftChar = s.charAt(l);
                freq.put(leftChar, freq.getOrDefault(leftChar, 0) - 1);
                l++;
            }
        }
         r++;
        if(r < s.length()){

            char ch = s.charAt(r);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(ch));
        }
    }

    return ans;
    }
    public int characterReplacement(String s, int k) {
        return solve(s,k);
    }
}