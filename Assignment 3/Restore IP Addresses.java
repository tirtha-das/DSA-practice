class Solution {

     void solve(int idx,String s, List<String>temp,List<String>ans){
        StringBuilder sb = new StringBuilder("");
        if(idx==s.length()){
           if(temp.size()==4){
            for(String cur:temp){
                if(sb.length()>0){
                    sb.append('.');
                }
               sb.append(cur);
            }
            ans.add(sb.toString());
           }
        }
        
        int num = 0;
        for(int i = idx;i<s.length();i++){
            sb.append(s.charAt(i));
            num *= 10;
            num += (s.charAt(i)-'0');
            if(num>255){
                break;
            }
            temp.add(sb.toString());
            solve(i+1,s,temp,ans);

            temp.remove(temp.size()-1);

            if(num==0 && idx==i){
                break;
            }
         }
     }


    public List<String> restoreIpAddresses(String s) {
        List<String> temp = new ArrayList<>();

        List<String>ans = new ArrayList<>();
        

        solve(0,s,temp,ans);

       return ans;

    }
}