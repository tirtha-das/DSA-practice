class Solution {
    public int atmostK(String s, int k){
        if(k==0) return 0;
        
        int[] freq = new int[26];
        
        Arrays.fill(freq,0);
        
        int ans = 0,left = 0,distinct=0;
        
        for(int right=0;right<s.length();right++){
            int idx = s.charAt(right)-'a';
            freq[idx]++;
            if(freq[idx]==1){
                distinct++;
            }
            
            while(left<right && distinct>k){
               int idx2 = s.charAt(left)-'a';
                freq[idx2]--;
                if(freq[idx2]==0){
                 distinct--;
                } 
                
                left++;
            }
           
           ans += (right-left+1);
        }
        
        return ans;
        
        
    }
    
    public int countSubstr(String s, int k) {
        //  code here
        int res =  atmostK(s,k)-atmostK(s,k-1);
        
        return res;
    }
}