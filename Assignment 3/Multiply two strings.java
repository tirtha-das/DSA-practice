class Solution {
    
    String solve(String small,String large,int start1,int start2,int n,int m,int[] res,boolean isNegative){
       
       
       for(int idx1 = n-1;idx1>=start1;idx1--){
           int carry = 0;
           List<Integer> multiply = new ArrayList<>();
           int num1 = small.charAt(idx1)-'0';
           
           for(int idx2=m-1;idx2>=start2;idx2--){
              int num2 = large.charAt(idx2)-'0';
              
              int mul = num1*num2;
              mul+=carry;
              multiply.add(mul%10);
              carry = mul/10;
           }
           
           multiply.add(carry);
           carry = 0;
           
           int shift = (n-1)-idx1;
           int it = 0;
           
           for(;it<multiply.size();it++){
               int val =  res[it+shift]+multiply.get(it)+carry;
               
               carry = val/10;
               res[it+shift] = val%10;
           }
           
           while(carry>0){
               int val =  res[it+shift]+carry;
               
               carry = val/10;
               res[it+shift] = val%10;
               it++;
           }
           
       }
       
       StringBuilder ans = new StringBuilder("");
       if(isNegative){
           ans.append("-");
       }
       
       for(int idx = n+m-1;idx>=0;idx--){
           if((ans.length()==0 || (ans.length()==1 && ans.charAt(0)=='-')) && res[idx]==0){
               continue;
           }else{
               char ch = (char)(res[idx]+'0');
               ans.append(ch);
           }
       }
       
       
       return ans.toString();
    }
    
    
    public String multiplyStrings(String s1, String s2) {
        // code here
       int n = s1.length(),m = s2.length();
       
       int[] res  = new int [n+m];
       
       Arrays.fill(res,0);
       
       int start1 = 0,start2=0;
       boolean isNegative = false;
      // int cnt1 = n,cnt2 = m;
       if(s1.charAt(start1)=='-'){
           start1++;
          
           isNegative = true;
       }
       
        if(s2.charAt(start2)=='-'){
           start2++;
           
           isNegative = !(isNegative);
       }
       
       
       while(start1<n){
           if(s1.charAt(start1)!='0'){
               break;
           }
           start1++;
       }
       
       if(start1==n){
           //System.out
           return new String("0");
       }
       
       while(start2<m){
           if(s2.charAt(start2)!='0'){
               break;
           }
           start2++;
       }
       
       if(start2==m){
           return new String("0");
       }
       
       if(n-start1<m-start2){
           return solve(s1,s2,start1,start2,n,m,res,isNegative);
       }
       
       return solve(s2,s1,start2,start1,m,n,res,isNegative);
       
       
    }
}