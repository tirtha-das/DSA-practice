class Solution {
     int ready(long num,boolean isPositive,long limit){
        if(num>limit){
            num = limit;
            if(!isPositive && num == limit){
                num+=1;
            }
        }

        if(!isPositive){
            num*=(-1);
            //num-=1;
        }



        return (int)num;
     }


    public int myAtoi(String s) {
        boolean start = false;
        boolean isPositive = true;
        long ans = 0;
        long limit = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

          if(ch>='0' && ch<='9'){
            start = true;
            int n = ch-'0';
            if(ans>0) ans*=10;
            ans+=n;
            System.out.println(ans);
            if(ans>limit){
                return ready(ans,isPositive,limit);
            }
          }           
 
           else if(start){
                
                    return ready(ans,isPositive,limit);
                
            }else{
                if(Character.isWhitespace(ch)){
                    continue;
                }else if(ch=='+'){
                    start = true;
                }else if(ch=='-'){
                    start = true;
                    isPositive = false;
                }else{
                    return 0;
                }
            }
        }
        
        return ready(ans,isPositive,limit);
    }
}