class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> mp = new HashMap<>();
        
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            int freq = mp.containsKey(ch)?mp.get(ch):0;

            mp.put(ch,freq+1);
        }

        int n = p.length();
        int cnt = mp.size();
        int left = 0;
        List<Integer>ans = new ArrayList<>();

        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(mp.containsKey(ch)){
                int freq = mp.get(ch);
                
                mp.put(ch,freq-1);
                if(freq==1){
                cnt--;
                }
            }

            if(right-left==n-1){
                if(cnt==0){
                    ans.add(left);
                }
                char ch2 = s.charAt(left);
            if(mp.containsKey(ch2)){
                int freq = mp.get(ch2);
                mp.put(ch2,freq+1);
                if(freq==0){
                cnt++;
                }
            }
            left++;
            }
        }

        return ans;
    }
}