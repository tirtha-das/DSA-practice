import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here
		Map<Character,Integer> mp = new HashMap<>();

		int l = 0,r=-1,cnt=0,ans=1;

		while(r<str.length()){
			if(cnt>k){
				char ch = str.charAt(l);
				int freq = mp.get(ch);
				mp.put(ch,freq-1);
				if(freq==1){
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
				if(freq==0){
					cnt++;
				}
				
				}
			}
		}

		return ans;
	}

}
