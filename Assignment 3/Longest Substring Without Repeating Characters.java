class Solution {
    public int lengthOfLongestSubstring(String str) {
        Map<Character,Integer> mp = new HashMap<>();

		int l = 0,r=-1,cnt=0,ans=0;

		while(r<str.length()){
			if(cnt>0){
				char ch = str.charAt(l);
				int freq = mp.get(ch);
				mp.put(ch,freq-1);
				if(freq==2){
					cnt--;
				}
				l++;
			}else{
				if(r>=0){
					ans = Math.max(ans,(r-l+1));
				}
				r++;
				if(r<str.length()){
				char ch = str.charAt(r);
				int freq = mp.containsKey(ch)?mp.get(ch):0;
				mp.put(ch,freq+1);
				if(freq==1){
					cnt++;
				}
				
				}
			}
		}

		return ans;
    }
}


